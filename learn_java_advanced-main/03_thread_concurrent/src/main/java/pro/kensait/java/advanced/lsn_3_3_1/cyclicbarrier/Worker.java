package pro.kensait.java.advanced.lsn_3_3_1.cyclicbarrier;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker extends Thread {
    private String name;
    private CyclicBarrier barrier; //【1】

    public Worker(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            // 何らかの処理を行う
            System.out.println("[ " + name + " ] do something...");
            doSomething(2, 8); // 2～8秒（ランダム）何かをする

            //【2】バリアーポイントに到達したため待機する
            System.out.println("[ " + name + " ] awaiting...");
            barrier.await();

        } catch (InterruptedException | BrokenBarrierException ex) {
            throw new RuntimeException(ex);
        }
    }
}