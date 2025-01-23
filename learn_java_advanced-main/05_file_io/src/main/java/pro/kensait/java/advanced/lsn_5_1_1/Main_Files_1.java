package pro.kensait.java.advanced.lsn_5_1_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class Main_Files_1 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("hoge/fuga/foo.txt");
        boolean isDirectory = Files.isDirectory(path);
        System.out.println("isDirectory => " + isDirectory);
        long length = Files.size(path);
        System.out.println("length => " + length);
        FileTime lastModified = Files.getLastModifiedTime(path);
        System.out.println("lastModified => " + lastModified);
        UserPrincipal owner = Files.getOwner(path);
        System.out.println("owner => " + owner);
    }
}