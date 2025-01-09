package pro.kensait.java.advanced.common;

import java.util.Random;

public class ThreadUtil {
    // 何かの仕事をしてように見える疑似的メソッド
    public static void doSomething(int second) {
        sleepAWhile(second * 1000);
    }

    // 何かの仕事をしてように見える疑似的メソッド
    public static void doSomething(int from, int to) {
        sleepRandomTime(from * 1000, to * 1000);
    }

    // 指定されたミリ秒間、一時停止する
    public static void sleepAWhile(long time) {
        try {
            Thread.sleep(time);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }

    // 指定されたミリ秒の期間で、ランダムに一時停止する
    public static void sleepRandomTime(long from, long to) {
        Random random = new Random();
        long sleepTime = from + random.nextInt((int)to - (int)from);
        try {
            Thread.sleep(sleepTime);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }
}