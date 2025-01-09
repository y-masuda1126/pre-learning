package pro.kensait.java.advanced.lsn_3_1_1.runnable;

public class Main_AnonymousClass {
    public static void main(String[] args) {
        int data = 3;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("[ Runnable ] start");
                long total = 0;
                for (long i = 0; i < 100_000_000_000L; i++) { // 1000億回
                    total += data;
                }
                System.out.println("[ Runnable ] finish, total => " + total);
            }
        });
        System.out.println("[ Main ] start");
        t.start();
        System.out.println("[ Main ] finish");
    }
}