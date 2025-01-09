package pro.kensait.java.advanced.lsn_3_3_1.countdownlatch;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {
    private String name;
    private CountDownLatch startSignal; //【1】
    private CountDownLatch doneSignal; //【2】

    public Worker(String name, CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.name = name;
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            //【3】処理を待機する
            System.out.println("[ " + name + " ] awaiting...");
            startSignal.await();

            //【4】処理を進める
            System.out.println("[ " + name + " ] do something...");
            doSomething(2, 8); // 2～8秒（ランダム）何かをする

            // 処理終了を通知する
            System.out.println("[ " + name + " ] finish");
            doneSignal.countDown();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }
}