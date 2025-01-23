package pro.kensait.java.advanced.lsn_7_1_4.genericmethod;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {
    static <E> List<E> createSameElemList(E element, int count) { //【1】
        List<E> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(element);
        }
        return list;
    }
}