package pro.kensait.java.advanced.lsn_5_2_2;

import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_Ser_1 {
    public static void main(String[] args) throws Exception {
        Person target = new Person("Alice", 30, "female"); //【1】
        Path serPath = Paths.get("alice.ser"); //【2】
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(serPath))) { //【3】
            oos.writeObject(target); //【4】
        }
    }
}