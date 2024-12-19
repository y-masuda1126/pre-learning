package pro.kensait.foo.api;

import pro.kensait.foo.internal.Common;

public class StringUtil {
    public int getLengthSum(String str1, String str2) {
        Common common = new Common();
        return common.add(str1.length(), str2.length());
    }
}