package pro.kensait.java.advanced.lsn_3_1_1.thread;

public class MyThread extends Thread { //【1】
    private int data; //【2】

    public MyThread(int data) { //【3】
        this.data = data;
    }

    @Override
    public void run() { //【4】
        System.out.println("[ MyThread ] start");
        long total = 0;
        for (long i = 0; i < 100_000_000_000L; i++) { // 1000億回
            total += data;
        }
        System.out.println("[ MyThread ] finish, total => " + total);
    }
}