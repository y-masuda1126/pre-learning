package pro.kensait.java.basic.lsn_11_2_1;

public class Main {
	public static void main(String[] args) {
		GeneralCustomer generalCustomer = new GeneralCustomer("yusuke", 500);
		generalCustomer.setId(1);
		if (!generalCustomer.overTotalPrice(500000)) {
			System.out.println("100万以下です。");
			generalCustomer.addPoint(500000);
			System.out.println(generalCustomer.getPoint());
		}
	}
}
