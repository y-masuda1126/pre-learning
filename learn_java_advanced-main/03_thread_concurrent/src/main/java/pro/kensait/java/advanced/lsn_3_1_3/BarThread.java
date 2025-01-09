package pro.kensait.java.advanced.lsn_3_1_3;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

public class BarThread extends Thread {
    private Shared shared; // 共有インスタンス

    public BarThread(Shared shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        System.out.println("[ BarThread ] start");
        // 5000ミリ秒かかる「比較的複雑な計算処理」を行い、結果が12345とする
        sleepAWhile(5000);
        int result = 12345;

        // 共有インスタンスに結果を設定する
        shared.setAndNotifyData(result); //【7】
        System.out.println("[ BarThread ] finish");
    }
}