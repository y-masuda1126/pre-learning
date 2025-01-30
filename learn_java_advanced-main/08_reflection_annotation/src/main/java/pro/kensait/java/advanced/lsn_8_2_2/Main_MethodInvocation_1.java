package pro.kensait.java.advanced.lsn_8_2_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main_MethodInvocation_1 {
    public static void main(String[] args) throws Exception {
        // 【1】Classインスタンスを取得する
        Class<?> clazz = Class.forName(
                "pro.kensait.java.advanced.lsn_8_2_2.Greeting");

        // 【2】メソッド実行対象クラスのConstructorインスタンスを取得する
        Constructor<?> constructor = clazz.getDeclaredConstructor();

        // 【3】メソッド実行対象クラスのインスタンスを生成する
        Object target = constructor.newInstance();
        Object target3 = constructor.newInstance();

        // 【4】Methodインスタンスを取得する
        Method method = clazz.getMethod("getYes");
//        Method method2 = clazz.getMethod("getNo"); // privateなので呼び出しできない
        Class<?>[] paramTypes = {String.class, int.class}; // 引数型の配列
        Method method3 = clazz.getMethod("getHello", paramTypes); //第2引数に配列を渡す

        // 【5】メソッドを実行する
        Object result = method.invoke(target);
//        Object result2 = method2.invoke(target);
        Object result3 = method3.invoke(target3, "Alice", 30);

        // 戻り値を表示する
        System.out.println(result);
//        System.out.println(result2);
        System.out.println(result3);
    }
}