package pro.kensait.java.advanced.lsn_4_1_4.closure;

public class Main {
    public static void main(String[] args) {
        int base = 100; //【1】ローカル変数を宣言

        // ラムダ式で関数型インタフェースを実装する
        CalcFunction cf = (x, y) -> {
            return base + x + y; //【2】ローカル変数を参照
        };
        int answer = cf.calc(30, 10); //【3】
        System.out.println(answer);

        // 遅延実行する
        Processor p = new Processor();
        p.process(cf);
//        base += 1; // 暗黙的にfinalになるので値の更新不可
    }
}