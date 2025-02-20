package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PaydayTest {

	@ParameterizedTest
	@CsvSource({"2020, 6, 25, 0",
		"2020, 6, 1, 24",
		"2020, 6, 26, 29"})
	public void testGetNextPayday(int yyyy, int mm, int dd, int expected) {
		Payday sut = new Payday(LocalDate.of(yyyy, mm, dd));
		int actual = sut.getNextPayday();
		assertEquals(expected, actual);
	}
}
