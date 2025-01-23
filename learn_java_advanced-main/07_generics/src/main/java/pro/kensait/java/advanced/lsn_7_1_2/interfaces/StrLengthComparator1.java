package pro.kensait.java.advanced.lsn_7_1_2.interfaces;

import java.util.Comparator;

public class StrLengthComparator1 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int length1 = ((String)o1).length();
        int length2 = ((String)o2).length();
        return length1 - length2;
    }
}