package junit.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Calculator2Test {

	@Test
	@DisplayName("addメソッドは2と3を入力すると5を返す")
	public void addTest() {
		Calculator2 sut = new Calculator2();
		assertEquals(5, sut.add(2, 3));
	}

	@Test
	@DisplayName("addメソッドは1と3を入力すると4を返す")
	public void addTest2() {
		Calculator2 sut = new Calculator2();
		assertEquals(4, sut.add(1, 3));
	}

}
