package pro.kensait.java.advanced.lsn_5_1_4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_BufferedOutputStream {
    public static void main(String[] args) {
        Path src = Paths.get("java_logo1.jpg"); //【1】
        Path dest = Paths.get("java_logo2.jpg"); //【2】

        try(InputStream is = Files.newInputStream(src);
                OutputStream os = Files.newOutputStream(dest)) { //【3】
            BufferedInputStream bis = new BufferedInputStream(is); //【4】
            BufferedOutputStream bos = new BufferedOutputStream(os); //【5】
            byte[] buf = new byte[10]; //【6】
            while (bis.read(buf) != -1) { //【7】
                bos.write(buf); //【8】
            }
            bos.flush(); //【9】これがないと書き込まれない
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}