package pro.kensait.java.advanced.lsn_4_1_5.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        doList(str -> System.out.println(str));
    }

    static void doList(Consumer<String> c) { //【1】
        List<String> strList = Arrays.asList("foo", "bar", "baz");
        for (String str : strList) {
            c.accept(str); //【2】
        }
    }
}