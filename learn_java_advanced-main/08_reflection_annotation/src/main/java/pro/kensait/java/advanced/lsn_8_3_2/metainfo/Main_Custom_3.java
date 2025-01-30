package pro.kensait.java.advanced.lsn_8_3_2.metainfo;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main_Custom_3 {
    public static void main(String[] args) {
        Method[] methods = Greeting.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            MyMetaInfo methodAnno = method.getAnnotation(MyMetaInfo.class);
            if (methodAnno != null) {
                System.out.println("===== Method =====");
                System.out.println("name => " + method.getName());
                System.out.println("MyMetaInfo#value => " + methodAnno.value());
            }
            Parameter[] params = method.getParameters();
            for (int j = 0; j < params.length; j++) {
                Parameter param = params[j];
                MyMetaInfo paramAnno = param.getAnnotation(MyMetaInfo.class);
                if (paramAnno != null) {
                    System.out.println("===== Parameter =====");
                    System.out.println("name => " + param.getName());
                    System.out.println("MyMetaInfo#value => " + paramAnno.value());
                    System.out.println("MyMetaInfo#elemName => " + paramAnno.elemName());
                }
            }
        }
    }
}