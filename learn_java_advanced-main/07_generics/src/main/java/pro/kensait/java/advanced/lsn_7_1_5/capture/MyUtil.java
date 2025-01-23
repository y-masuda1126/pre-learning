package pro.kensait.java.advanced.lsn_7_1_5.capture;

public class MyUtil {
    public <T> void printProperty1(MyContainer<T> container) {
        System.out.println(container.getProperty());
    }

    public <T> void printProperty2(MyContainer<T> container, T t) {
        container.setProperty(t);
        System.out.println(container.getProperty());
    }
}