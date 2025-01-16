package pro.kensait.java.advanced.lsn_4_1_5.bifunction;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        int answer1 = compute(30, 10, (x, y) -> x + y);
        System.out.println(answer1);

        int answer2 = compute(30, 10, (x, y) -> x - y);
        System.out.println(answer2);
    }

    static int compute(int x, int y, BiFunction<Integer, Integer, Integer> bf) { //【1】
        if (50 < x) {
            throw new RuntimeException("引数不正");
        }
        int value = bf.apply(x, y); //【2】
        if (100 < value) {
            throw new RuntimeException("計算結果不正");
        }
        return value;
    }
}