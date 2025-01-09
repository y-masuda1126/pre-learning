package pro.kensait.java.advanced.lsn_3_1_1.runnable;

public class MyRunnable implements Runnable {
    private int data;

    public MyRunnable(int data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[ MyRunnable ] start");
        long total = 0;
        for (long i = 0; i < 100_000_000_000L; i++) { // 1000億回
            total += data;
//            System.out.println("[ MyRunnable ] progress, total => " + total);
        }
        System.out.println("[ MyRunnable ] finish, total => " + total);
    }
}