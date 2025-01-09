package pro.kensait.java.advanced.lsn_3_2_4.callable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main_Done {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CallableTask task = new CallableTask("foo", 8);

        try {
            System.out.println("[ Main ] starting task...");
            Future<Integer> future = executor.submit(task);
            while (! future.isDone()) { //【1】
                System.out.println("[ Main ] do something..."); // 何か別の処理を行う
                sleepAWhile(1000);
            }
            Integer result = future.get(); //【2】
            System.out.println("result => " + result);
            System.out.println("[ Main ] finish");
        } catch (InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }

        executor.shutdown();
    }
}