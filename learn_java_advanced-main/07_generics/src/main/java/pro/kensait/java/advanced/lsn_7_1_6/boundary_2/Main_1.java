package pro.kensait.java.advanced.lsn_7_1_6.boundary_2;

import java.util.Arrays;
import java.util.List;

public class Main_1 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        MyNumberUtil_1.process(list1);

        List<Number> list2 = Arrays.asList(1, 2, 3);
        MyNumberUtil_1.process(list2);

        List<Object> list3 = Arrays.asList(1, 2, 3);
        // MyNumberUtil_1.process(list3); コンパイルエラー
    }
}