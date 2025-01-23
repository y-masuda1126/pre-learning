package pro.kensait.java.advanced.lsn_7_1_5.capture;

// ワイルドカードキャプチャー
public class Main {
    public static void main(String[] args) {

        MyContainer<Integer> ctn1 = new MyContainer<>(100);
        MyContainer<?> ctn2;

        // MyContainer<?>に対してMyContainer<T>を代入することは可能
        ctn2 = ctn1;

        // MyContainer<T>に対してMyContainer<?>を代入することはできない（コンパイルエラー）
        // ctn1 = ctn2;

        // MyContainer<T>の仮引数に対して、MyContainer<?>の実引数を渡す際に、
        // Tに対する型が何らかの型に一意に決まり、型の安全性を保証できる場合には
        // コンパイルエラーにはならない（ワイルドカードキャプチャー）
        MyUtil hoge = new MyUtil();
        hoge.printProperty1(ctn2);

        // ただし、以下のコードはコンパイルエラーになる
        // hoge.printProperty2(ctn2, 100);

        // この処理は、これだけ見ると問題ないように思える
        // しかし、これを可能にしてしまうと、以下のようなコードもOKということに
        // なってしまうため、型の安全性が保証されない
        // hoge.printProperty2(ctn2, 100L);
    }
}