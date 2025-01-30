package pro.kensait.java.advanced.lsn_8_3_2.maxlength;

public class Main {
    public static void main(String[] args) {
//        Greeting greeting = new Greeting("Foooooooooo"); // 11文字
    	Greeting greeting = new Greeting("Fooooooooo"); // 10文字
    	Greeting greeting2 = new Greeting("Fo"); // 2文字
        AnnotationProcessor.checkMaxLength(greeting);
        AnnotationProcessor.checkMinLength(greeting2);
        greeting.getHello(25);
    }
}