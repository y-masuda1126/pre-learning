package pro.kensait.java.advanced.lsn_5_2_2;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable { //【1】
    private static final long serialVersionUID = 4510489553386281586L; // UID宣言しなくとも自動生成されるが宣言を推奨
//    private static final long serialVersionUID = 4510489553386281585L; // シリアライズとデシリアライズのUIDが異なる場合エラー
    // フィールド
    private String name;
    private int age;
    private String gender;
//    transient private String gender; // シリアライズ対象から除外
    // コンストラクタ
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    // アクセサメソッド
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(name, other.name);
    }
}
