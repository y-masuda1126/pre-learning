package pro.kensait.java.advanced.lsn_3_2_5.collection;

import java.util.List;
import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer> {
    private List<Integer> intList;

    public SumTask(List<Integer> intList) {
        this.intList = intList;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int value : intList) {
            result += value;
        }
        return result;
    }
}