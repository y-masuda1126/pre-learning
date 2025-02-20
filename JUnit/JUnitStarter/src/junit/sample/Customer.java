package junit.sample;

public class Customer {

	int id;
	int age;
	String address;
	int count;

	public Customer() {
	}

	//省略

	public boolean checkBonus(int age, String address, int count) {
		return age >= 20 && address.contentEquals("東京都") && count >= 1;
	}

}
