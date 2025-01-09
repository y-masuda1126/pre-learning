package pro.kensait.java.advanced.lsn_3_1_3;

public class FooThread extends Thread {
    private Shared shared; // 共有インスタンス

    public FooThread(Shared shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        System.out.println("[ FooThread ] start");
        Integer result = shared.getAndWaitData(); //【5】
        System.out.println("[ FooThread ] finish, result => " + result); //【6】
    }
}