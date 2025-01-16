package pro.kensait.java.advanced.lsn_4_1_6;

import java.util.function.Consumer;

public class Main_1 {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            Consumer<String> c = System.out::println;
            c.accept("Hello, World!");
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            Consumer<String> c = (str) -> { System.out.println(str); };
            c.accept("Hello, World!");
            System.out.println("=> end");
        }
    }
}