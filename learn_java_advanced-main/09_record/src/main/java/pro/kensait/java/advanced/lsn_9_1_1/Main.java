package pro.kensait.java.advanced.lsn_9_1_1;

public class Main {
    public static void main(String[] args) {
        Person alice = new Person("Alice", 25, "female");
        System.out.println(alice.age());
//        alice.age = "26"; // 参照のみのため、セットは不可
    }
}