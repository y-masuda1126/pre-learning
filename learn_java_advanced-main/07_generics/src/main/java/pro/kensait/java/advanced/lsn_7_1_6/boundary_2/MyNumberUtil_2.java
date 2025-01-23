package pro.kensait.java.advanced.lsn_7_1_6.boundary_2;

import java.util.List;

public class MyNumberUtil_2 {
    public static void process(List<? super Number> list) {
        // 以下はコンパイルエラー
        // Integer num = list.get(0);

        // Objectとしてしか取得できない
        Object num = list.get(0);
        System.out.println(num);

        // addはできる
        list.add(100);
    }
}