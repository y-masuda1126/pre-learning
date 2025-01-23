package pro.kensait.java.advanced.lsn_7_1_6.boundary_2;

import java.util.List;

public class MyNumberUtil_1 {
    public static void process(List<? extends Number> list) {
        Number num = list.get(0);
        System.out.println(num);

        // 以下はコンパイルエラー
        // list.add(100);
    }
}