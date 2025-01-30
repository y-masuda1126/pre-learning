package pro.kensait.java.advanced.lsn_8_2_2;

public class Person {
    // フィールド
    private String personName;
    private int age;
    private GenderType gender;
    private String address;
    // コンストラクタ
    public Person(String name, int age, GenderType gender, String address) {
        super();
        this.personName = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    // アクセサメソッド
	public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
		this.age = age;
	}
    public GenderType getGender() {
        return gender;
    }
    public void setGender(GenderType gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Person [personName=" + personName + ", age=" + age + ", gender=" + gender
                + ", address=" + address + "]";
    }
}