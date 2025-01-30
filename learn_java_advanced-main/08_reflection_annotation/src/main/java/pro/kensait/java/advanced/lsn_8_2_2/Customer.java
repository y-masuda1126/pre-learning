package pro.kensait.java.advanced.lsn_8_2_2;

public class Customer {
    // フィールド
    private Integer id;
    private String customerName;
    private GenderType gender;
    private String address;
    // コンストラクタ
    public Customer(Integer id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }
    // アクセサメソッド
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
        return "Customer [id=" + id + ", customerName=" + customerName + ", gender=" + gender
                + ", address=" + address + "]";
    }
}