package pro.kensait.java.advanced.lsn_7_1_5.unknown;

import java.util.List;

public class MyUtil {
    public static void printList(List<?> list) { //【1】
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}