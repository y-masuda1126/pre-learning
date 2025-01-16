package pro.kensait.java.advanced.lsn_4_1_2.comparator;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}