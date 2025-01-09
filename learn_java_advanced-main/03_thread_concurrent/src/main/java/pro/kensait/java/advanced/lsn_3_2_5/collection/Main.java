package pro.kensait.java.advanced.lsn_3_2_5.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        // 1から10万までのInteger型リストを作る
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            intList.add(i + 1);
        }

        // 並列度を10と設定し、リストを10個に分割する
        int paraCount = 10;
        List<List<Integer>> splitedListList =
                splitIntegerList(intList, paraCount); // リスト分割のためのユーティリティ

        // 分割された個々のリストを担当するSumTaskを作り、リストに格納する
        List<Callable<Integer>> taskList = new ArrayList<>();
        for (List<Integer> splitedList : splitedListList) {
            taskList.add(new SumTask(splitedList));
        }

        // invokeAllで10個のタスクを同時に起動して待機する
        ExecutorService executor = Executors.newFixedThreadPool(paraCount);
        try {
            List<Future<Integer>> futureList = executor.invokeAll(taskList);
            // 10個のタスクがすべて終了したら、それぞれの結果を集計する
            long sum = 0L;
            for (Future<Integer> future : futureList) {
                sum += future.get();
            }
            System.out.println("sum => " + sum);
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }

        executor.shutdown();
    }

    private static List<List<Integer>> splitIntegerList(List<Integer> intList,
            int parallelCount) {
        int splitedListCount = Double.valueOf(
                Math.ceil(intList.size() / parallelCount)).intValue();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0;; i++) {
            int startPoint = i * splitedListCount;
            int endPoint = startPoint + splitedListCount;
            if (endPoint < intList.size()) {
                resultList.add(intList.subList(startPoint, endPoint));
                continue;
            } else if (intList.size() == endPoint) {
                resultList.add(intList.subList(startPoint, endPoint));
                break;
            } else if (intList.size() < endPoint) {
                endPoint = intList.size();
                resultList.add(intList.subList(startPoint, endPoint));
                break;
            }
        }
        return resultList;
    }
}