package pro.kensait.java.advanced.lsn_7_1_6.boundary_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_2 {
    public static void main(String[] args) {
//        List<Integer> list1 = Arrays.asList(1, 2, 3);
        // MyNumberUtil_2.process(list1); コンパイルエラー

        List<Number> list2 = Arrays.asList(1, 2, 3);
        MyNumberUtil_2.process(list2);

        List<Object> list3 = Arrays.asList(1, 2, 3);
        MyNumberUtil_2.process(list3);
        
        List<Integer> list7= new ArrayList<>(List.of(1, 2, 3));
        MyNumberUtil_3.process(list7);
        
        List<Integer> list4 = Arrays.asList(1, 2, 3);
         MyNumberUtil_3.process(list4);

        List<Number> list5 = Arrays.asList(1, 2, 3);
        MyNumberUtil_3.process(list5);

        List<Object> list6 = Arrays.asList(1, 2, 3);
        MyNumberUtil_3.process(list6);
    }
}