package pro.kensait.java.advanced.lsn_5_1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_BufferedReader {
    public static void main(String[] args) {
        Path path1 = Paths.get("hoge/fuga/foo.txt"); //【1】

        try (BufferedReader br = Files.newBufferedReader(path1,
                StandardCharsets.UTF_8)) { //【2】
            String line;
            while ((line = br.readLine()) != null) { //【3】
                System.out.println(line);
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        Path path2 = Paths.get("hoge/fuga/bar.txt");

        try (BufferedReader br = Files.newBufferedReader(path2,
                Charset.forName("Shift_JIS"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}