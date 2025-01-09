package pro.kensait.java.advanced.lsn_3_2_4.callable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main_Get_3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CallableTask task = new CallableTask("foo", 8);

        try {
            System.out.println("[ Main ] starting task...");
            Future<Integer> future = executor.submit(task); //【1】8秒かかる処理を起動
            doSomething(5); //【2】5秒間、何らかの処理を行う
            Integer result = future.get(); //【3】待機してから結果を取得する（3秒待機）
            System.out.println("result => " + result);
            System.out.println("[ Main ] finish");   
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }
        executor.shutdown();
    }
}