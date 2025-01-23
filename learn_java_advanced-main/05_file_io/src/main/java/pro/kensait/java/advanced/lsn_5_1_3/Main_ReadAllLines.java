package pro.kensait.java.advanced.lsn_5_1_3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main_ReadAllLines {
    public static void main(String[] args) {
        Path path = Paths.get("hoge/fuga/foo.txt");
        try {
            List<String> fileContents = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String line : fileContents) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}