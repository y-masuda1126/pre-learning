package pro.kensait.java.advanced.lsn_9_1_2;

import java.io.Serializable;

public record Person(String name, int age, String gender) implements Serializable {
    private static final long serialVersionUID = -6011243720394071084L;

    public Person { //【1】
        if (name == null) throw new IllegalArgumentException("name is null");
        if (age < 0) throw new IllegalArgumentException("age is under 0");
    }

    @Override
    public String toString() { //【2】
        return "[ name => " + name + ", age => " + age + "]";
    }

    public void sayHello() { //【3】
        String message = "こんにちは！私は" + name + "、" + age + "歳です。";
        System.out.println(message);
    }
}