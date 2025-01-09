package pro.kensait.java.advanced.lsn_3_2_4.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main_Timeout {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CallableTask task = new CallableTask("foo", 8);

        try {
            System.out.println("[ Main ] starting task...");
            Future<Integer> future = executor.submit(task); //【1】8秒かかる処理を起動
            Integer result = future.get(4, TimeUnit.SECONDS); //【2】4秒でタイムアウト
            System.out.println("result => " + result);
            System.out.println("[ Main ] finish");
        } catch(InterruptedException | ExecutionException | TimeoutException ex) {
            throw new RuntimeException(ex);
        }

        executor.shutdown();
    }
}