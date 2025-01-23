package pro.kensait.java.advanced.lsn_7_1_5.unknown;

import java.util.Arrays;
import java.util.List;

public class Main_1 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<String> strList = Arrays.asList("foo", "bar", "baz");

        // コンパイルエラー
        // MyUtil.print(list1);

        // どっちもOK
        MyUtil.printList(intList);
        MyUtil.printList(strList);
    }
}