package pro.kensait.java.advanced.lsn_7_1_6.boundary_3;

import java.util.List;

public class MyCopyUtil_2 {
    public static void process(List<? extends Bar> src, //【1】
            List<? super Bar> dest) { //【2】
        for (Bar bar : src) {
            dest.add(bar);
        }
    }
}