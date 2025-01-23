package pro.kensait.java.advanced.lsn_7_1_3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            MyContainerIF<Integer> container = new MyContainer<>(100);
            int num = container.getProperty();
            System.out.println(num);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            MyContainer<String> container = new MySubContainer<String>("Hello");
            String message = container.getProperty();
            System.out.println(message);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_3 *****");
            List<Number> numList = new ArrayList<>();

            // 追加
            numList.add(100); // OK
            numList.add(100L); // OK
            Number n = 100;
            numList.add(n); // OK
            // numList.add(new Object()); コンパイルエラー

            // 取り出し
            Object val1 = numList.get(0); // OK
            Number val2 = numList.get(0); // OK
            // Integer val2 = numList.get(0); コンパイルエラー
        }
    }
}