package pro.kensait.java.advanced.lsn_3_3_1.countdownlatch;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws Exception {
        CountDownLatch startSignal = new CountDownLatch(1); //【1】処理開始用ラッチ
        CountDownLatch doneSignal = new CountDownLatch(3); //【2】処理終了用ラッチ

        //【3】3つのWorkerスレッドを生成し、起動する
        System.out.println("[ Main ] starting all threads...");
        new Worker("t1", startSignal, doneSignal).start();
        new Worker("t2", startSignal, doneSignal).start();
        new Worker("t3", startSignal, doneSignal).start();
        sleepAWhile(100);

        //【4】1秒間、何らかの処理を行う
        System.out.println("[ Main ] do something...");
        doSomething(1);

        //【5】Workerスレッドの処理を進める
        System.out.println("[ Main ] proceeding all threads...");
        startSignal.countDown();

        //【6】4秒間、何らかの処理を行う
        System.out.println("[ Main ] do something...");
        doSomething(4);

        //【7】Workerスレッドの処理終了を待つ
        System.out.println("[ Main ] waiting for all threads to finish...");
        doneSignal.await();
        System.out.println("[ Main ] finish");
    }
}