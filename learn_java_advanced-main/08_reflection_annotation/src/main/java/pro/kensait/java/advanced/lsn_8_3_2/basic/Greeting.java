package pro.kensait.java.advanced.lsn_8_3_2.basic;

@SomeAnnotation
public class Greeting {
    @SomeAnnotation("自分の名前")
    private String personName;

    public Greeting(String personName) {
        this.personName = personName;
    }

    @SomeAnnotation("挨拶する")
    public void sayHello(
            @SomeAnnotation(value = "年齢", order = 1) int age) {
        System.out.println("私は" + personName + "、" + age + "歳です。");
    }
}