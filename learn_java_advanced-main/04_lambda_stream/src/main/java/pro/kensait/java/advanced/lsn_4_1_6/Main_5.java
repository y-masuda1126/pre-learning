package pro.kensait.java.advanced.lsn_4_1_6;

import java.util.function.Consumer;

public class Main_5 {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            Printer printer = new Printer();
            Consumer<String> c1 = msg -> printer.print(msg);
            c1.accept("Hello, World!");
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            Printer printer = new Printer();
            Consumer<String> c2 = printer::print;
            c2.accept("Hello, World!");
            System.out.println("=> end");
        }
    }
}