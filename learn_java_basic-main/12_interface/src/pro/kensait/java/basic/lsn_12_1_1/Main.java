package pro.kensait.java.basic.lsn_12_1_1;

public class Main {
    public static void main(String[] args) {
        Foo foo1 = new Hoge(); //【1】
        Foo foo2 = new Piyo(); //【2】
        Piyo piyo1 = new Piyo();
        foo1.sayYes(); //【3】
        foo2.sayYes(); //【4】
//        foo2.sayHello();
//        foo2.sayGoodnight();
        piyo1.sayHello();
        piyo1.sayGoodnight();
    }
}