package pro.kensait.java.advanced.lsn_3_1_1.join;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("メインスレッド開始");

        // 一つ目のスレッドを生成し、起動する
        MyParaThread t1 = new MyParaThread("foo", 8000L);
        t1.start();
        // 二つ目のスレッドを生成し、起動する
        MyParaThread t2 = new MyParaThread("bar", 5000L);
        t2.start();

        // 待ち合わせ
        t1.join(); // t1の処理終了を待機する
        t2.join(); // t2の処理終了を待機する
        
        MyParaThread t3 = new MyParaThread("hoge", 5000L);
        t3.start();
        
        System.out.println("メインスレッド終了");
    }
}