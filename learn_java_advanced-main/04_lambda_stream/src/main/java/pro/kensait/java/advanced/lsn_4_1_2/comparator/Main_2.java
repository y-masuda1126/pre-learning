package pro.kensait.java.advanced.lsn_4_1_2.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_2 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Japan", "USA", "France");
        Collections.sort(strList, new Comparator<String>() { //【1】
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println(strList);
    }
}