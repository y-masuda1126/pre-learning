package pro.kensait.java.advanced.lsn_4_1_6;

import java.util.function.BiFunction;

import pro.kensait.java.advanced.lsn_4_1_3.functional.CalcFunction;

public class Main_3 {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            CalcFunction addFunc = (x, y) -> {return StaticCalculator.add(x, y);};
            int answer = addFunc.calc(30, 10);
            System.out.println(answer);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            CalcFunction addFunc = StaticCalculator::add;
            int answer = addFunc.calc(30, 10);
            System.out.println(answer);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_3 *****");
            BiFunction<Integer, Integer, Integer> addFunc = StaticCalculator::add;
            int answer = addFunc.apply(30, 10);
            System.out.println(answer);
            System.out.println("=> end");
        }
    }
}