package pro.kensait.java.advanced.lsn_7_1_2.interfaces;

import java.util.Comparator;

public class StrLengthComparator2 implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        return length1 - length2;
    }
}