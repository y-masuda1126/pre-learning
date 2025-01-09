package pro.kensait.java.advanced.lsn_3_2_3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main_FixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        RunnableTask2 task = new RunnableTask2();
        System.out.println("[ Main ] starting task...");
        // 2秒遅れて開始し、10秒毎に繰り返しタスクを実行する
        executor.scheduleAtFixedRate(task, 2L, 10L, TimeUnit.SECONDS);
        System.out.println("[ Main ] finish");
    }
}