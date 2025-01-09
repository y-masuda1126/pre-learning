package pro.kensait.java.advanced.lsn_3_2_4.runnable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        RunnableTask fooTask = new RunnableTask("foo", 8);

        try {
            Future<?> fooFuture = executor.submit(fooTask); //【1】Runnableタスクを投入
            fooFuture.get(); //【2】
            System.out.println("[ Main ] foo finish ");
            doSomething(5); // 5秒間何かをする
            System.out.println("[ Main ] finish");
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }

        executor.shutdown();
    }
}