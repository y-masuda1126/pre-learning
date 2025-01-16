package pro.kensait.java.advanced.lsn_4_1_2.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_1 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Japan", "USA", "France");
        Collections.sort(strList, new MyComparator());
        System.out.println(strList);
    }
}