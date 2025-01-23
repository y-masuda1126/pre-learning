package pro.kensait.java.advanced.lsn_7_1_6.boundary_1;

import java.util.Arrays;
import java.util.List;

public class Main_2 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Long> longList = Arrays.asList(1L, 2L, 3L);

        // どっちもOK
        MyNumberUtil_2.printSum(intList);
        MyNumberUtil_2.printSum(longList);
    }
}