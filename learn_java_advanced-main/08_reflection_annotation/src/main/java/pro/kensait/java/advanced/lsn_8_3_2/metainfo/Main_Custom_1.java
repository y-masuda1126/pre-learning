package pro.kensait.java.advanced.lsn_8_3_2.metainfo;

public class Main_Custom_1 {
    public static void main(String[] args) {
        MyMetaInfo classAnno = Greeting.class.getAnnotation(MyMetaInfo.class);
        System.out.println("MyMetaInfo#value => " + classAnno.value());
    }
}