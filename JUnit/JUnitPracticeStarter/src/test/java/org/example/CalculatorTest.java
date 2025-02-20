package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
	Calculator cal;

	@BeforeEach
	public void newClaculator() {
		cal = new Calculator();
	}

	@Test
	public void testTaxPrice() {
		int expected = 110;
		int actual = cal.taxPrice(100);
		assertEquals(expected, actual);
	}

	@Test
	public void testTaxPriceException() {
		assertThrows(IllegalArgumentException.class, () -> cal.taxPrice(-100));
	}

	// （補足）例外メッセージの確認も検証する場合
	@Test
	public void testTaxPriceException2() {
		//メッセージの確認
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> cal.taxPrice(-100));
		assertEquals("価格は0円以上にしてください", e.getMessage());
	}

	@ParameterizedTest
	@CsvSource({ "8, 100, 108",
			"8, 3000, 3240",
			"10, 50, 55",
			"8, 50 ,54",
			"5, 50 ,52"
	})
	public void testTaxPriceParameterized(int rate, int price, int expected) {
		int actual = cal.taxPrice(rate, price);
		assertEquals(expected, actual);
	}
}
