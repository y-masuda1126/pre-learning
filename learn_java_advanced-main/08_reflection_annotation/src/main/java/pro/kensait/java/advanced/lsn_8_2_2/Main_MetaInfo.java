package pro.kensait.java.advanced.lsn_8_2_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main_MetaInfo {
    public static void main(String[] args) throws Exception {
        // Classインスタンスを取得する
        Class<?> clazz = Class.forName("java.lang.Integer");

        // フィールドを分析する
        System.out.println("===== フィールド情報の出力 =====");
        Field[] fields = clazz.getFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            // 修飾子を表示する
            System.out.print(Modifier.toString(field.getModifiers()));
            // 型を表示する
            System.out.print(" " + field.getType().getName());
            // フィールド名を表示する
            System.out.println(" " + field.getName());
        }

        // コンストラクタを分析する
        System.out.println("===== コンストラクタ情報の出力 =====");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> constructor = constructors[i];
            // 修飾子を表示する
            System.out.print(Modifier.toString(constructor.getModifiers()));
            // 引数の型を表示する
            Class<?>[] params1 = constructor.getParameterTypes();
            System.out.print(" String(");
            for (int j = 0; j < params1.length; j++) {
                System.out.print(params1[j].getName() + " ");
            }
            System.out.println(")");
        }

        // メソッドを分析する
        System.out.println("===== メソッド情報の出力 =====");
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            // 修飾子を表示する
            System.out.print(Modifier.toString(method.getModifiers()));
            // 戻り値の型を表示する
            System.out.print(" " + method.getReturnType().getName());
            // メソッド名を表示する
            System.out.print(" " + method.getName());
            // 引数の型を表示する
            Class<?>[] params2 = method.getParameterTypes();
            System.out.print("(");
            for (int j = 0; j < params2.length; j++) {
                System.out.print(params2[j].getName() + " ");
            }
            System.out.println(")");
        }
    }
}