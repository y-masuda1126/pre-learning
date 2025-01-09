package pro.kensait.java.advanced.lsn_3_1_1.runnable;

public class Main {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable(3); //【1】
        Thread t = new Thread(r); //【2】スレッドを生成する
        System.out.println("[ Main ] start");
        t.start(); // スレッドを起動する
        System.out.println("[ Main ] finish");
    }
}