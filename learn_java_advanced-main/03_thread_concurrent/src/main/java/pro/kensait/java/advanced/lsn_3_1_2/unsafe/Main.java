package pro.kensait.java.advanced.lsn_3_1_2.unsafe;

public class Main {
    public static void main(String[] args) throws Exception {
        //【6】共有インスタンスを生成する
        Shared shared = new Shared(0);

        //【7】1つ目のスレッドを生成し、起動する
        MyThread t1 = new MyThread(shared, 1);
        t1.start();

        //【8】2つ目のスレッドを生成し、起動する
        MyThread t2 = new MyThread(shared, 2);
        t2.start();

        // 待ち合わせする
        t1.join();
        t2.join();

        System.out.println("最終的な値 => " +
                shared.getData()); //【9】本来は30になるはずだが…
    }
}