package pro.kensait.java.advanced.lsn_3_1_1.sleep;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("[ MyThread ] start");
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        System.out.println("[ MyThread ] finish");
    }
}