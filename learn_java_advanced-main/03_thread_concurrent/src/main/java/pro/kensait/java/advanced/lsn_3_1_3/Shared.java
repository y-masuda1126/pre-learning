package pro.kensait.java.advanced.lsn_3_1_3;

public class Shared {
    private Integer data; // 計算結果

    //【1】計算結果が格納されるまで待機し、その後値を返す
    public synchronized Integer getAndWaitData() {
        if (data == null) {
            try {
                wait(); //【2】
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            }
        }
        return data;
    }

    //【3】計算結果を格納し、通知する
    public synchronized void setAndNotifyData(Integer data) {
        this.data = data;
        notify(); //【4】
    }
}