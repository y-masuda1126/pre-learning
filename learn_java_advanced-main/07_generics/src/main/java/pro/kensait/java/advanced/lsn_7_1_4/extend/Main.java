package pro.kensait.java.advanced.lsn_7_1_4.extend;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Long> longList = MyUtil.createSameElemList(10L);
        System.out.println(longList);
        List<Float> floatList = MyUtil.createSameElemList(3.5F);
        System.out.println(floatList);
        List<Integer> intList = MyUtil.createSameElemList(3);
        System.out.println(intList);
//        List<String> strList = MyUtil.createSameElemList("3"); // コンパイルエラー
//        System.out.println(strList);
    }
}