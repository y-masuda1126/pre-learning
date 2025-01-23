package pro.kensait.java.advanced.lsn_5_2_2;

import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_Ser_2 {
    public static void main(String[] args) throws Exception {
        Path serPath = Paths.get("alice.ser"); //【1】
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(serPath))){ //【2】
            Person target = (Person) ois.readObject(); //【3】
            System.out.println(target);
        }
    }
}