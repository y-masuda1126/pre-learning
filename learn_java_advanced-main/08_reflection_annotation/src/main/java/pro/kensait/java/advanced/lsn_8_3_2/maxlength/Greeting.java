package pro.kensait.java.advanced.lsn_8_3_2.maxlength;

@MyMetaInfo("挨拶クラス")
public class Greeting {
    @MyMetaInfo("自分の名前")
    @MaxLength(10)
    @MinLength(3)
    private String personName;

    public Greeting(String personName) {
        this.personName = personName;
    }

    @MyMetaInfo("挨拶する")
    public void getHello(
            @MyMetaInfo(value = "年齢", elemName = "age") int age) {
        System.out.println(
                "こんにちは！私は" + personName + "、" + age + "歳です。");
    }
}