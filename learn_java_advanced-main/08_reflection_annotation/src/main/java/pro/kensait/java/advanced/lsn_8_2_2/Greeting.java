package pro.kensait.java.advanced.lsn_8_2_2;

import java.util.Date;

public class Greeting {
    public String getYes() {
        return "Yes!";
    }
    private String getNo() {
        return "No!";
    }
    public String getHello(String name, int age) {
        return "Hello! 私は" + name + "、" + age + "歳です。";
    }
    static Date now; 
    static {
        now = new Date();
        System.out.println(now);
    }
}
