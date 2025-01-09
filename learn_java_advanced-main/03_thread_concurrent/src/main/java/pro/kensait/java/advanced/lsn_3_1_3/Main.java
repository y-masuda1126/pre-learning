package pro.kensait.java.advanced.lsn_3_1_3;

public class Main {
    public static void main(String[] args) throws Exception {
        // 共有インスタンスを生成する
        Shared shared = new Shared();

        // FooThreadを生成し、起動する
        new FooThread(shared).start();

        // BarThreadを生成し、起動する
        new BarThread(shared).start();
    }
}