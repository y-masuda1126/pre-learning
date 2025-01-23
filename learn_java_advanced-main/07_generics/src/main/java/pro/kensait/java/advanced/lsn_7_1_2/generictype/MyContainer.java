package pro.kensait.java.advanced.lsn_7_1_2.generictype;

public class MyContainer<T> { //【1】
    private T property;
    public MyContainer(T property) { //【2】
        this.property = property;
    }
    public T getProperty() { //【3】
        return property;
    }
    public void setProperty(T property) { //【4】
        this.property = property;
    }
}