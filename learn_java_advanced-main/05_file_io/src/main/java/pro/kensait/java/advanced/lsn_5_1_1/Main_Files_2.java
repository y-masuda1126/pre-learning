package pro.kensait.java.advanced.lsn_5_1_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_Files_2 {
    public static void main(String[] args) throws IOException {
        {
            System.out.println("***** snippet_1 *****");
            Path srcFile = Paths.get("hoge/fuga/foo.txt");
            Path destFile = Paths.get("hoge/fuga/foo2.txt");
            Files.copy(srcFile, destFile);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            Path srcFile = Paths.get("hoge/fuga/foo.txt");
            Path destFile = Paths.get("hoge/piyo/foo.txt");
            Files.move(srcFile, destFile);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_3 *****");
            Path srcDir = Paths.get("hoge/piyo");
            Path destDir = Paths.get("hoge/piyo2");
            Files.move(srcDir, destDir);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_4 *****");
            Path destFile = Paths.get("hoge/fuga/foo2.txt");
            Files.delete(destFile);
            System.out.println("=> end");
        }
        {
            // 元に戻す
            Path srcFile = Paths.get("hoge/fuga/foo.txt");
            Path srcDir = Paths.get("hoge/piyo");
            Path destFile = Paths.get("hoge/piyo/foo.txt");
            Path destDir = Paths.get("hoge/piyo2");
            Files.move(destDir, srcDir);
            Files.move(destFile, srcFile);
        }
    }
}