package pro.kensait.java.advanced.lsn_7_1_2.generictype;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            MyContainer<Integer> container1 = new MyContainer<>(100); //【1】
            int num = container1.getProperty(); //【2】
            System.out.println(num);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            MyContainer<String> container2 = new MyContainer<>("Hello");
            String str = container2.getProperty();
            System.out.println(str);
            System.out.println("=> end");
        }
    }
}