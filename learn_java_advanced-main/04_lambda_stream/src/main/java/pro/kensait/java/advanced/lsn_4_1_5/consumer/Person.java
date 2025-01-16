package pro.kensait.java.advanced.lsn_4_1_5.consumer;

import java.util.function.Consumer;

public class Person {
    // フィールド
    private String name;
    private int age;
    private String gender;
    // 【1】コンストラクタ
    private Person() {}
    // ゲッター
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    //【2】フィールド値の設定用メソッド
    public Person withName(String name) {
        this.name = name;
        return this;
    }
    public Person withAge(int age) {
        this.age = age;
        return this;
    }
    public Person withGender(String gender) {
        this.gender = gender;
        return this;
    }
    // ビルダーメソッド
    public static Person build(Consumer<Person> builder) { //【3】
        Person person = new Person();
        builder.accept(person); //【4】
        return person;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }
}