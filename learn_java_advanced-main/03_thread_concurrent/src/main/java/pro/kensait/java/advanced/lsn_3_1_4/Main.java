package pro.kensait.java.advanced.lsn_3_1_4;

public class Main {
    public static void main(String[] args) {
        // スレッドt1を生成し、起動する
        MyThread t1 = new MyThread();
        t1.start();
    }
}