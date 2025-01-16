package pro.kensait.java.advanced.lsn_4_2_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            list.stream()
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_3 *****");
            Stream.iterate(10, x -> x * 2)
                    .limit(20)
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_4 *****");
            IntStream.range(1, 11)
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_5 *****");
            String[] strArray = {"foo", "bar", "baz"};
            Arrays.stream(strArray)
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_6 *****");
            int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            Arrays.stream(intArray)
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
    }
}