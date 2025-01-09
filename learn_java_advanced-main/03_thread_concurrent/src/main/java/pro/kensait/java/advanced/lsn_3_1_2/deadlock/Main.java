package pro.kensait.java.advanced.lsn_3_1_2.deadlock;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

public class Main {
    public static void main(String[] args) {
        //【1】初期値が0の共有インスタンスを生成する
        Shared instanceA = new Shared(0);

        //【2】初期値が10000の共有インスタンスを生成する
        Shared instanceB = new Shared(10000);

        //【3】加算値が5のスレッド"t1"を生成し、起動する
        DeadlockThread t1 = new DeadlockThread("t1", instanceA, instanceB, 5);
        t1.start();

        //【4】加算値が7のスレッド"t2"を生成し、"t1"から1秒遅れて起動する
        sleepAWhile(1000);
        DeadlockThread t2 = new DeadlockThread("t2", instanceB, instanceA, 7);
        t2.start();
    }
}