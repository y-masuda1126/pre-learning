package pro.kensait.java.advanced.lsn_7_1_6.boundary_1;

import java.util.List;

public class MyNumberUtil_1 {
    public static void printSum(List<Number> list) {
        long total = 0;
        for (Number num : list) {
            total = total + num.longValue();
        }
        System.out.println(total);
    }
}