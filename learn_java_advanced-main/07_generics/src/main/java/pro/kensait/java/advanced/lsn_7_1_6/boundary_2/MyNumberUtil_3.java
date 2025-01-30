package pro.kensait.java.advanced.lsn_7_1_6.boundary_2;

import java.util.List;

public class MyNumberUtil_3 {
    public static void process(List<? super Integer> list) {
        // 以下はコンパイルエラー
//        Number num1 = list.get(0);
        // 以下はコンパイルエラー
//        Integer num3 = list.get(0);

        // Objectとしてしか取得できない
        Object num2 = list.get(0);
        System.out.println(num2);

        // addはできる
        list.add(100);
    }
}