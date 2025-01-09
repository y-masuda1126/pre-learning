package pro.kensait.java.advanced.lsn_3_2_4.runnable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

public class RunnableTask implements Runnable {
    private String name; // 名前
    private int count; // カウント

    public RunnableTask(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId(); // スレッドID
        System.out.println("[ RunnableTask = " + name + " ] start, "
                + "threadId => " + threadId);

        int value = 1;
        for (int i = 0; i < count; i++) { // カウント分ループする
            System.out.println("[ RunnableTask = " + name + " ] processing...");
            value = value * 3; // 値を3倍する
            sleepAWhile(1000); // 意図的に1秒停止する
        }

        System.out.println("[ RunnableTask = " + name + " ] finish, "
                + "value => " + value);
    }
}