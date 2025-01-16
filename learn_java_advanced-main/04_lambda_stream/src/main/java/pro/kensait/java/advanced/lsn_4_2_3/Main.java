package pro.kensait.java.advanced.lsn_4_2_3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            List<Integer> list = Arrays.asList(8, 4, 1, 10, 4, 2, 5, 6, 9, 4);
            list.stream()
                    .filter(x -> x % 2 == 0) //【1】
                    .distinct() //【2】
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            list.stream()
                    .map(x -> x * 2) //【1】
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_3 *****");
            List<String> strList = Arrays.asList("Japan", "USA", "France");
            strList.stream()
                    .map(str -> str.toUpperCase()) //【1】
                    .sorted() //【2】
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_4 *****");
            List<String> strList = Arrays.asList("Japan", "USA", "France");
            strList.stream()
                    .flatMap(str -> Stream.of(str.toLowerCase(), str.toUpperCase())) //【1】
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_5 *****");
            List<Integer> list = Arrays.asList(6, 9, 2, 10, 3, 1, 5, 8, 7, 4); //【1】
            list.stream() //【2】
                    .sorted() //【3】
                    .skip(3) //【4】
                    .limit(5) //【5】
                    .forEach(System.out::println);
            System.out.println("=> end");
        }
    }
}