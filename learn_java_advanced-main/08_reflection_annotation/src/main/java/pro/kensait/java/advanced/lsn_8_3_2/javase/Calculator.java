package pro.kensait.java.advanced.lsn_8_3_2.javase;

public class Calculator {
    @Deprecated //【1】
    public static int add(int x, int y) {
        return x + y;
    }

    @Deprecated(forRemoval = true) //【2】
    public static int subtract(int x, int y) {
        return x - y;
    }
}