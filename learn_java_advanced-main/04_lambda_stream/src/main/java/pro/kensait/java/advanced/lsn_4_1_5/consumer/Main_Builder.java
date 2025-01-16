package pro.kensait.java.advanced.lsn_4_1_5.consumer;

public class Main_Builder {
    public static void main(String[] args) {
        Person alice = Person.build(person -> {
            person.withName("Alice").withAge(25).withGender("female");
        });
        System.out.println(alice);
    }
}