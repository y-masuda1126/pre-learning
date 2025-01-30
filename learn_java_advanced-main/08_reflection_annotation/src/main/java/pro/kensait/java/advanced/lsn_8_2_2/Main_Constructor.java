package pro.kensait.java.advanced.lsn_8_2_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main_Constructor {
    public static void main(String[] args) throws Exception {
        // Classインスタンスを取得する
        Class<?> clazz = Class.forName(
                "pro.kensait.java.advanced.lesson8_2_2.Person");

        // メソッド実行対象クラスのConstructorインスタンスを取得する
        Constructor<?> constructor = clazz.getDeclaredConstructor(
                String.class, Integer.TYPE, String.class);

        // メソッド実行対象クラスのインスタンスを生成する
        Object target = constructor.newInstance("Alice", 25, "中央区1-1-1");

        // Methodインスタンスを取得する
        Method method = clazz.getDeclaredMethod("toString");

        // メソッドを実行する
        Object result = method.invoke(target);

        // 戻り値を表示する
        System.out.println(result);
    }
}