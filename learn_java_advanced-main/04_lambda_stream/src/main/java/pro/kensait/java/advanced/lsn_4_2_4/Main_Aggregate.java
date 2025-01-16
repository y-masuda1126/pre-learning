package pro.kensait.java.advanced.lsn_4_2_4;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main_Aggregate {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            long count = list.stream()
                    .filter(x -> x % 2 == 0)
                    .count();
            System.out.println(count);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            long sum = list.stream()
                    .mapToInt(x -> x * 10) //【1】
                    .sum(); //【2】
            System.out.println(sum);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_3 *****");
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            OptionalDouble opt = list.stream()
                    .filter(x -> 5 < x)
                    .mapToInt(x -> x)
                    .average(); //【1】
            double avg = opt.orElse(0.0d); //【2】
            System.out.println(avg);
            System.out.println("=> end");
        }
    }
}