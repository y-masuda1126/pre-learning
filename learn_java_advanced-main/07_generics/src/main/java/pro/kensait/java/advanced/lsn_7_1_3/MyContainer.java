package pro.kensait.java.advanced.lsn_7_1_3;

public class MyContainer<T> implements MyContainerIF<T> {
    private T property;
    public MyContainer(T property) {
        this.property = property;
    }
    public T getProperty() {
        return property;
    }
    public void setProperty(T property) {
        this.property = property;
    }
}