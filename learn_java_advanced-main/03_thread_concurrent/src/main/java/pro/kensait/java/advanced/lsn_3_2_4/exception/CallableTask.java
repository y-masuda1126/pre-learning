package pro.kensait.java.advanced.lsn_3_2_4.exception;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("[ CallableExTask ] start");
        throw new Exception("タスク実行中に例外発生");
    }
}