package pro.kensait.java.advanced.lsn_4_2_4;

import java.util.Arrays;
import java.util.List;

public class Main_Reduce {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            List<String> strList = Arrays.asList("Alice", "Bob", "Carol", "Dave");
            String concatedString = strList.stream()
                    .reduce((result, param) -> result + "/" + param) //【1】
                    .orElse(""); //【2】
            System.out.println(concatedString);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            List<String> strList = Arrays.asList("Alice", "Bob", "Carol", "Dave");
            int strLength = strList.stream()
                    .mapToInt(str -> str.length())
                    .reduce((result, param) -> result + param) //【1】
                    .orElse(0); //【2】
            System.out.println(strLength);
            System.out.println("=> end");
        }
    }
}