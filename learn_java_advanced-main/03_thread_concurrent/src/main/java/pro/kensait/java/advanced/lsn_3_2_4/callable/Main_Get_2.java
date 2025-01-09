package pro.kensait.java.advanced.lsn_3_2_4.callable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main_Get_2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        String name = "foo"; // 名前
        int count = 8; // カウント

        try {
            System.out.println("[ Main ] starting task...");
            Future<Integer> future = executor.submit(() -> {
                long threadId = Thread.currentThread().getId(); // スレッドID
                System.out.println("[ CallableTask = " + name + " ] start, "
                        + "threadId => " + threadId);
                int value = 1;
                for (int i = 0; i < count; i++) { // カウント分ループする
                    System.out.println("[ CallableTask = " + name + " ] processing...");
                    value = value * 3; // 値を3倍する
                    sleepAWhile(1000); // 意図的に1秒停止する
                }
                System.out.println("[ CallableTask = " + name + " ] finish, "
                        + "value => " + value);
                return value; // 実行結果を返す
            });
            Integer result = future.get();
            System.out.println("result => " + result);
            System.out.println("[ Main ] finish");   
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }

        executor.shutdown();
    }
}