package pro.kensait.java.advanced.lsn_4_1_5.supplier;

import java.util.function.Supplier;

public class Main {
    static boolean infoLevel = true;

    public static void main(String[] args) {
        // ログを出力する（ラムダ式を渡す）
        info(() -> "THIS IS INFO LOG.");
    }

    static void info(Supplier<String> s) { //【1】
        if (infoLevel) {
            System.out.println("[ INFO ] " + s.get()); //【2】
        }
    }
}