package pro.kensait.java.advanced.lsn_3_1_2.safe;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

public class Shared {
    private int data;

    public Shared(int data) {
        this.data = data;
    }

    // dataフィールドへの更新処理
    // この処理は「アトミックな処理」ではないため、
    // synchronizedキーワードによってこのメソッドを同期化する必要がある
    synchronized public void addData(int num) {
        int tmp = this.data + num;
        sleepAWhile(10); // 10ミリ秒間、一時停止（割り込みのチャンス）
        this.data = tmp;
    }

    public int getData() {
        return data;
    }
}