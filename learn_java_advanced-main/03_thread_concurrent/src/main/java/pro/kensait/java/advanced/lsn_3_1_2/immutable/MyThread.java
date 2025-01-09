package pro.kensait.java.advanced.lsn_3_1_2.immutable;

public class MyThread extends Thread {
    private String property;

    public MyThread(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    @Override  
    public void run() {
        for(int i = 0; i < 10; i++) {
            property = property + "!";
        }
    }
}