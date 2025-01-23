package pro.kensait.java.advanced.lsn_5_1_1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_Path {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            Path path = Paths.get("hoge/fuga/foo.txt");
            System.out.println(path);
        }
        {
            System.out.println("***** snippet_2 *****");
            Path path = Paths.get("hoge", "fuga", "foo.txt");
            System.out.println(path);
        }
        {
            System.out.println("***** snippet_3 *****");
            Path path = Paths.get("./hoge/fuga/foo.txt");
            Path fileName = path.getFileName();
            System.out.println("fileName => " + fileName);
            Path parent = path.getParent();
            System.out.println("parent => " + parent);
            Path absolutePath1 = path.toAbsolutePath();
            System.out.println("absolutePath => " + absolutePath1);
            Path absolutePath2 = path.toAbsolutePath().normalize();
            System.out.println("normalized absolutePath => " + absolutePath2);
        }
    }
}