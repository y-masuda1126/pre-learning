package pro.kensait.java.advanced.lsn_3_1_1.sleep;

public class Main_Interrupt {
    public static void main(String[] args) throws Exception {
        // スレッドを生成する
        MyThread t = new MyThread();

        System.out.println("[ Main ] start");
        // スレッドを起動する
        t.start();

        // 割り込む
        t.interrupt();
        System.out.println("[ Main ] finish");
    }
}