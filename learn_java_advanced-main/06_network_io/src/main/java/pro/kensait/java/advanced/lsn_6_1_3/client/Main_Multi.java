package pro.kensait.java.advanced.lsn_6_1_3.client;

public class Main_Multi {
    public static void main(String[] args) {
        new Thread(new ClientTask("Alice")).start();
        new Thread(new ClientTask("Bob")).start();
        new Thread(new ClientTask("Carol")).start();
    }
}