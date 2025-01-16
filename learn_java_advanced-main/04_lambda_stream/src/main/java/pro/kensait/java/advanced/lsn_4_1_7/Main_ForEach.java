package pro.kensait.java.advanced.lsn_4_1_7;

import java.util.Arrays;
import java.util.List;

public class Main_ForEach {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        //【1】ラムダ式を渡す
        list.forEach(x -> System.out.println(x));

        //【2】メソッド参照を渡す
        list.forEach(System.out::println);
    }
}