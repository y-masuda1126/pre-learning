package pro.kensait.java.advanced.lsn_7_1_6.boundary_3;

import java.util.List;

public class MyCopyUtil_1 {
    public static void process(List<Bar> src, List<Bar> dest) {
        for (Bar bar : src) {
            dest.add(bar);
        }
    }
}