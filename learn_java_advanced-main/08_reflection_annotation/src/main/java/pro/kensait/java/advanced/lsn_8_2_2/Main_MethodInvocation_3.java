package pro.kensait.java.advanced.lsn_8_2_2;

import java.lang.reflect.Method;

public class Main_MethodInvocation_3 {
    public static void main(String[] args) throws Exception {
        // Classインスタンスを取得する
        Class<?> clazz = Class.forName(
                "pro.kensait.java.advanced.lsn_8_2_2.Greeting");

        // メソッド実行対象クラスのインスタンスを生成する
        Object target = clazz.getDeclaredConstructor().newInstance();

        // 【1】Methodインスタンスを取得する
        Method method = clazz.getMethod("getHello", String.class, Integer.TYPE);

        // メソッドを実行する
        Object[] params = {"Alice", 25}; //【2】
        Object result = method.invoke(target, params); //【3】

        // 戻り値を表示する
        System.out.println(result);
    }
}