package pro.kensait.java.advanced.lsn_3_1_2.unsafe;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

public class Shared {
    private int data;

    public Shared(int data) {
        this.data = data; //【1】
    }

    // 【2】dataフィールドへの更新処理
    // この処理は「アトミックな処理」ではないため、本来は
    // synchronizedキーワードによってこのメソッドを同期化する必要がある
    public void addData(int num) {
        int tmp = this.data + num;
        sleepAWhile(10); //【3】10ミリ秒間、一時停止（割り込みのチャンス）
        this.data = tmp;
    }

    public int getData() {
        return data;
    }
}