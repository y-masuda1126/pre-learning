package pro.kensait.java.advanced.lsn_4_1_6;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main_2 {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            doList(System.out::println);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            doList(str -> System.out.println(str));
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_3 *****");
            // 引数を文字列連結し、その結果をコンソール表示する
            doList(str -> System.out.println(str + str));

            // 引数の文字列長を判定した上でコンソール表示する
            doList(str -> {
                if (3 < str.length()) System.out.println(str);
            });
            System.out.println("=> end");
        }
    }

    static void doList(Consumer<String> c) {
        List<String> strList = Arrays.asList("foo", "bar", "hoge");
        for (String str : strList) {
            c.accept(str);
        }
    }
}