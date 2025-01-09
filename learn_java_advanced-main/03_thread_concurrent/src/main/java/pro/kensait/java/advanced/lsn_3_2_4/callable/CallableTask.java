package pro.kensait.java.advanced.lsn_3_2_4.callable;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> { //【1】
    private String name; // 名前
    private int count; // カウント

    public CallableTask(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public Integer call() throws Exception { //【2】
        long threadId = Thread.currentThread().getId(); // スレッドID
        System.out.println("[ CallableTask = " + name + " ] start, "
                + "threadId => " + threadId);

        int value = 1;
        for (int i = 0; i < count; i++) { // カウント分ループする
            System.out.println("[ CallableTask = " + name + " ] processing...");
            value = value * 3; // 値を3倍する
            sleepAWhile(1000); // 意図的に1秒停止する
        }
        System.out.println("[ CallableTask = " + name + " ] finish, "
                + "value => " + value);

        return value; //【3】実行結果を返す
    }
}