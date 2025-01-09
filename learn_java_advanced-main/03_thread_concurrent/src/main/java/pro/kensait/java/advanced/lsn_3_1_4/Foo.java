package pro.kensait.java.advanced.lsn_3_1_4;

public class Foo {
    public void process() {
        String value = ThreadLocalHolder.get().get("name"); //【3】
        System.out.println("[ Foo#process ] name => " + value);
    }
}
