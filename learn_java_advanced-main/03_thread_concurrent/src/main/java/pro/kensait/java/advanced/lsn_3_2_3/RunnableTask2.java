package pro.kensait.java.advanced.lsn_3_2_3;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.Iterator;
import java.util.List;

public class RunnableTask2 implements Runnable {
    Iterator<Integer> it = List.of(7, 14, 4, 10).iterator();

    @Override
    public void run() {
        int count = it.next();
        System.out.println("[ RunnableTask ] start, count => " + count);

        int value = 1;
        for (int i = 0; i < count; i++) { // カウント分ループする
            System.out.println("[ RunnableTask ] processing...");
            value = value * 3; // 値を3倍する
            sleepAWhile(1000); // 意図的に1秒停止する
        }

        System.out.println("[ RunnableTask ] finish, value => " + value);
    }
}