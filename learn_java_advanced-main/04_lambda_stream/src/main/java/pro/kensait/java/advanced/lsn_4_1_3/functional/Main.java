package pro.kensait.java.advanced.lsn_4_1_3.functional;

public class Main {
    public static void main(String[] args) {
        CalcFunction cf = (x, y) -> { //【1】
            return x + y;
        };
        int answer = cf.calc(30, 10); //【2】
        System.out.println(answer);
        
        CalcFunction cf2 = (x, y) -> { //【1】
        	int z = x * 2;
            return z / y;
        };
        int answer2 = cf2.calc(30, 10); //【2】
        System.out.println(answer2);
    }
}