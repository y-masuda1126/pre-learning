package junit.sample;

public class Calculator {

    public int add(int x, int y) { //足し算
        return x + y;
    }

    public int sub(int x, int y) { //引き算
        return x - y;
    }

    public int mul(int x, int y) { //掛け算
        return x * y;
    }

    public float div(int x, int y) { //割り算
        if (y == 0) throw new IllegalArgumentException("第二引数に0が指定されました");

        return (float) x / (float) y;
    }
}
