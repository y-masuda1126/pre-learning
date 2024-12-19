package pro.kensait.hoge;

import pro.kensait.foo.api.StringUtil;

public class Application {

    public static void main(String[] args) {
        int result = new StringUtil().getLengthSum("ABCDE", "ABCDEFGH");
        System.out.println(result);

        // int result2 = new Common().add(10, 20);
        // System.out.println(result2);
    }
}