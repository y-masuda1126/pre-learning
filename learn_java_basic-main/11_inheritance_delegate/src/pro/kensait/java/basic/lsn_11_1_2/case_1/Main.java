package pro.kensait.java.basic.lsn_11_1_2.case_1;

public class Main {
	public static void main(String[] args) {
		Bar bar = new Bar(30, 10);
		Foo foo = new Foo(30);
		int answer = bar.add();
		int answer2 = foo.add();
		System.out.println(answer);
		System.out.println(answer2);
	}
}
