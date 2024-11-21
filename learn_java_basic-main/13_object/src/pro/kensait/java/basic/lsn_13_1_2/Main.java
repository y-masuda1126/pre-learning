package pro.kensait.java.basic.lsn_13_1_2;

public class Main {
    public static void main(String[] args) {
        Foo foo1 = new Foo();
        Foo foo2 = new Foo();
        boolean flag1 = foo1 == foo2; //【1】falseになる
        Foo foo3 = foo1; //【2】
        boolean flag2 = foo1 == foo3; //【3】trueになる
        System.out.println(flag1 + ", " + flag2);
        Person person1 = new Person("yusuke", 31, "千葉県");
        Person person2 = new Person("yusuke", 31, "千葉県");
        Person person3 = new Person("clinks", 31, "千葉県");
        System.out.println(person1);
        boolean flag3 = person1 == person2;
        System.out.println(flag3);
        System.out.println(person1.equals(person2));
        System.out.println(person1.equals(person3));
        System.out.println(person1.hashCode());
        System.out.println(person3.hashCode());
        int hash1 = person1.hashCode();
        int hash2 = person2.hashCode();
        boolean hashflag1 = hash1 == hash2;
        System.out.println(hashflag1);
    }
}
