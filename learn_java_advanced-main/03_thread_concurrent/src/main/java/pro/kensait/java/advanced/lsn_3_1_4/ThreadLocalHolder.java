package pro.kensait.java.advanced.lsn_3_1_4;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalHolder {
    private static ThreadLocal<Map<String, String>> context =
            new ThreadLocal<>() { //【1】
        @Override
        public Map<String, String> initialValue() { //【2】
            return new HashMap<String, String>();
        }
    };

    public static Map<String, String> get() {
        return context.get();
    }
}