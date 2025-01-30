package pro.kensait.java.advanced.lsn_8_1_1;

public class Main_1 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader1 = ClassLoader.getPlatformClassLoader(); //【1】
        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader(); //【2】
        ClassLoader parent1 = classLoader1.getParent(); //【3】
        ClassLoader parent2 = classLoader2.getParent(); //【4】
        System.out.println("プラットフォーム・クラスローダーの本体 => " + classLoader1);
        System.out.println("プラットフォーム・クラスローダーの親 => " + parent1);
        System.out.println("システム・クラスローダーの本体 => " + classLoader2);
        System.out.println("システム・クラスローダーの親 => "  + parent2);
    }
}