package pro.kensait.java.advanced.lsn_3_1_1.parallel;

public class Main {
    public static void main(String[] args) {
        // 一つ目のスレッドを生成し、起動する
        MyParaThread t1 = new MyParaThread("foo", 8000L);
        t1.start();

        // 二つ目のスレッドを生成し、起動する
        MyParaThread t2 = new MyParaThread("bar", 5000L);
        t2.start();
    }
}