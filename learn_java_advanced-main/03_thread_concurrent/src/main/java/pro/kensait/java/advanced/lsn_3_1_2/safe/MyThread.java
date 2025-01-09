package pro.kensait.java.advanced.lsn_3_1_2.safe;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

public class MyThread extends Thread {
    private Shared shared; // 共有インスタンス
    private int num; // 加算値

    public MyThread(Shared shared, int num) {
        this.shared = shared;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sleepRandomTime(400, 500); // ランダムに400～500ミリ秒間、一時停止する
            shared.addData(num);
            System.out.println(num + "加算する => " + shared.getData());
        }
    }
}