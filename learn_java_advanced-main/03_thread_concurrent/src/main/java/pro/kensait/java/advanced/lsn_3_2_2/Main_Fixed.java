package pro.kensait.java.advanced.lsn_3_2_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main_Fixed {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        RunnableTask fooTask = new RunnableTask("foo", 8);
        RunnableTask barTask = new RunnableTask("bar", 15);
        RunnableTask bazTask = new RunnableTask("baz", 5);
        System.out.println("[ Main ] starting all threads...");
        executor.submit(fooTask);
        executor.submit(barTask);
        executor.submit(bazTask);
        System.out.println("[ Main ] finish");
    }
}