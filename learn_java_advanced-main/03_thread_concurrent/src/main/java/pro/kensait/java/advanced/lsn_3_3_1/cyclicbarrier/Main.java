package pro.kensait.java.advanced.lsn_3_3_1.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(3, new MyBarrierAction()); //【1】
        System.out.println("[ Main ] starting all threads...");
        //【2】3つのWorkerスレッドを生成し、起動する
        new Worker("t1", barrier).start();
        new Worker("t2", barrier).start();
        new Worker("t3", barrier).start();
        System.out.println("[ Main ] finish");
    }
}