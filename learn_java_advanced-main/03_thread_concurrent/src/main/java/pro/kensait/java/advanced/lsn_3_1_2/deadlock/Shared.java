package pro.kensait.java.advanced.lsn_3_1_2.deadlock;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

public class Shared {
    private int data;

    public Shared(int data) {
        this.data = data;
    }

    // dataフィールドへの更新処理
    public void addData(int num) {
        sleepAWhile(100); // 意図的に100ミリ秒間、一時停止する
        this.data = this.data + num;
    }

    public int getData() {
        return data;
    }
}
