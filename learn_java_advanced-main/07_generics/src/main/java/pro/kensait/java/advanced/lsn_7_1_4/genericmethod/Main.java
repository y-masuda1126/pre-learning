package pro.kensait.java.advanced.lsn_7_1_4.genericmethod;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strList = MyUtil.createSameElemList("Hello", 10);
        System.out.println(strList);
        
        List<Integer> intList = MyUtil.createSameElemList(55555, 9);
        System.out.println(intList);
        
        List<Number> numList = MyUtil.createSameElemList(55555, 9);
        System.out.println(numList);
        
        List<Object> objList = MyUtil.createSameElemList("55555", 9);
        System.out.println(objList);
        
        List<Long> lngList = MyUtil.createSameElemList(1000000000000000000L, 3);
        System.out.println(lngList);
    }
}