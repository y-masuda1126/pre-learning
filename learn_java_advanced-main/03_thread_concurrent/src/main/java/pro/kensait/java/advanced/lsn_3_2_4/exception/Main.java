package pro.kensait.java.advanced.lsn_3_2_4.exception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CallableTask task = new CallableTask();
        try {
            System.out.println("[ Main ] starting task...");
            Future<Integer> future = executor.submit(task);
            Integer result = future.get(); // ここで例外発生
            System.out.println("result => " + result);
            System.out.println("[ Main ] finish");
        } catch(InterruptedException | ExecutionException ex) { // ExecutionExceptionにラップされる
            throw new RuntimeException(ex);
        } finally {
            executor.shutdown();
        }
    }
}