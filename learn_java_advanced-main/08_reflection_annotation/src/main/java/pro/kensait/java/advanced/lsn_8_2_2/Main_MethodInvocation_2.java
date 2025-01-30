package pro.kensait.java.advanced.lsn_8_2_2;

import java.lang.reflect.Method;

public class Main_MethodInvocation_2 {
    public static void main(String[] args) throws Exception {
        // Classインスタンスを取得する
        Class<?> clazz = Class.forName(
                "pro.kensait.java.advanced.lsn_8_2_2.Greeting");

        // メソッド実行対象クラスのインスタンスを生成する
        Object target = clazz.getDeclaredConstructor().newInstance();
        
        // Methodインスタンスを取得する
        Method method = clazz.getDeclaredMethod("getNo");
        Method method2 = clazz.getDeclaredMethod("getYes");

        // privateメソッドをアクセス可能にする
        method.setAccessible(true);
        method2.setAccessible(true);

        // メソッドを実行する
        Object result = method.invoke(target);
        Object result2 = method2.invoke(target);

        // 戻り値を表示する
        System.out.println(result);
        System.out.println(result2); // publicメソッドの呼び出しも可能。わざわざする意味ないが
    }
}