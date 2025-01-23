package pro.kensait.java.advanced.lsn_5_2_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        Path src = Paths.get("java_logo1.jpg");
        Path dest = Paths.get("java_logo2.jpg");

        // メモリ上の一時領域への書き込み
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //【1】
        try(InputStream is = Files.newInputStream(src)) {
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buf = new byte[10];
            while (bis.read(buf) != -1) { //【2】
                baos.write(buf); //【3】
            }
        }

        // メモリ上の一時領域からの読み込み
        byte[] byteArray = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(byteArray); //【4】
        try(OutputStream os = Files.newOutputStream(dest)) { //【5】
            BufferedOutputStream bos = new BufferedOutputStream(os);
            int c;
            while ((c = bais.read()) != -1) { //【6】
                bos.write(c); //【7】
            }
            bos.flush();
        }
    }
}