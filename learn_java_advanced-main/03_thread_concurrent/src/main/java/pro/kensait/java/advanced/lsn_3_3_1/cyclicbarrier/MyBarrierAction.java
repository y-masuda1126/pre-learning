package pro.kensait.java.advanced.lsn_3_3_1.cyclicbarrier;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

public class MyBarrierAction extends Thread {
    @Override
    public void run() {
        System.out.println("[ BarrierAction ] do something...");
        doSomething(5);
        System.out.println("[ BarrierAction ] finish");
    }
}