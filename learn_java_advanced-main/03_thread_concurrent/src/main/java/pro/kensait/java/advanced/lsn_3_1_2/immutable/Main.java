package pro.kensait.java.advanced.lsn_3_1_2.immutable;

public class Main {
    public static void main(String[] args) throws Exception {
        String property = "foo";
        
        // 一つ目のスレッドを生成し、起動する
        MyThread t1 = new MyThread(property);
        t1.start();

        // 二つ目のスレッドを生成し、起動する
        MyThread t2 = new MyThread(property);
        t2.start();

        // t1、t2の処理終了を待機する
        t1.join();
        t2.join();

        // 当初は同じプロパティを共有していたが、Stringクラスはイミュータブルなため、
        // t1、t2、双方でプロパティを同時に更新しても影響はない
        System.out.println("t1 => " + t1.getProperty());
        System.out.println("t2 => " + t2.getProperty());
    }
}