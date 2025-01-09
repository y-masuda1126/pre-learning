package pro.kensait.java.advanced.lsn_3_2_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main_Single {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor(); //【1】
        RunnableTask fooTask = new RunnableTask("foo", 4); //【2】
        RunnableTask barTask = new RunnableTask("bar", 4);
        RunnableTask bazTask = new RunnableTask("baz", 4);
        System.out.println("[ Main ] starting all threads...");
        executor.submit(fooTask); //【3】
        executor.submit(barTask);
        executor.submit(bazTask);
        System.out.println("[ Main ] finish");
    }
}