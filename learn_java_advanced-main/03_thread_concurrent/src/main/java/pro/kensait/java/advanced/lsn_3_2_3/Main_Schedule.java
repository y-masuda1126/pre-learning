package pro.kensait.java.advanced.lsn_3_2_3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main_Schedule {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        RunnableTask task = new RunnableTask();
        System.out.println("[ Main ] starting task...");
        executor.schedule(task, 5L, TimeUnit.SECONDS);
        // ScheduledExecutorServiceは、Runnableの投入を待ち続けるため、
        // shutdownを呼び出さないと、プログラムが終了しない
        System.out.println("[ Main ] shutdown");
        System.out.println("[ Main ] finish");
    }
}