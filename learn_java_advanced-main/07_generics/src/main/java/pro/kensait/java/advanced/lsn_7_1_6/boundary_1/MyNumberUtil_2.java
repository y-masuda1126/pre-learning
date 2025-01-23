package pro.kensait.java.advanced.lsn_7_1_6.boundary_1;

import java.util.List;

public class MyNumberUtil_2 {
    public static void printSum(List<? extends Number> list) { //【1】
        long total = 0;
        for (Number num : list) {
            total = total + num.longValue();
        }
        System.out.println(total);
    }
}