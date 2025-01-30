package pro.kensait.java.advanced.lsn_8_3_2.javase;

import java.util.ArrayList;
import java.util.List;

public class Main_JavaSE_Annotation {
    @SuppressWarnings("unused") //【1】
    private int tmp1 = 0;

    public static void main(String[] args) {
        @SuppressWarnings("unused") //【2】
        int tmp2 = 0;

        @SuppressWarnings("rawtypes") //【3】
        List list = new ArrayList();
        list.add(0,1);
        list.add(1,1);
        list.add(2,"test");
        list.add(0,"test");
        System.out.println(list);

        Integer val1 = null;
        @SuppressWarnings({ "unused", "static-access" }) //【4】
        int val2 = val1.parseInt("1234");
    }
}