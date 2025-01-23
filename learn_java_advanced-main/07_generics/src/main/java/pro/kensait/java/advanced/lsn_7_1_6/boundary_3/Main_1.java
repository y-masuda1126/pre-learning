package pro.kensait.java.advanced.lsn_7_1_6.boundary_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_1 {
    public static void main(String[] args) {
        List<Bar> list1 = Arrays.asList(new Bar(), new Bar(), new Bar());

        List<Bar> list2 = new ArrayList<>();

        MyCopyUtil_1.process(list1, list2);

        for (Bar bar : list2) {
            System.out.println(bar);
        }
    }
}
