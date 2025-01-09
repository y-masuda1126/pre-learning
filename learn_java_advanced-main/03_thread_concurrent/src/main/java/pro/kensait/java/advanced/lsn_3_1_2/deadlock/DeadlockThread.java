package pro.kensait.java.advanced.lsn_3_1_2.deadlock;

public class DeadlockThread extends Thread {
    private String name;
    private Shared shared1; // 共有インスタンス1
    private Shared shared2; // 共有インスタンス2
    private int num; // 加算値

    public DeadlockThread(String name, Shared share1, Shared share2,
            int num) {
        this.name = name;
        this.shared1 = share1;
        this.shared2 = share2;
        this.num = num;
    }

    @Override
    public void run() {
        while (true) {
            //【1】まず共有インスタンス1をロックする
            synchronized (shared1) {
                // 共有インスタンス1の値にスレッドが保持している加算値を足し込む
                System.out.println("[ " + name + ", shared1 ] " + shared1.getData());
                shared1.addData(num);
                System.out.println("[ " + name + ", shared1 ] " + shared1.getData());

                //【2】共通インスタンス1にロックをかけたまま、共有インスタンス2をロックする
                synchronized (shared2) { 
                    // 共有インスタンス2の値にスレッドが保持している加算値を足し込む
                    System.out.println("[ " + name + ", shared2 ] " + shared2.getData());
                    shared2.addData(num);
                    System.out.println("[ " + name + ", shared2 ] " + shared2.getData());
                }
            }
        }
    }
}