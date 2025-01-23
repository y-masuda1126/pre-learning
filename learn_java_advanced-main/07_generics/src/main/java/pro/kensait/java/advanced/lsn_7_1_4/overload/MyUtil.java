package pro.kensait.java.advanced.lsn_7_1_4.overload;

public class MyUtil {
    public static <T extends CharSequence> void process(T param) { //【1】
        System.out.println("[ process, 1st ] param => " + param);
    }
    public static <T extends Comparable<T>> void process(T param) { //【2】
        System.out.println("[ process, 2nd ] param => " + param);
    }
}