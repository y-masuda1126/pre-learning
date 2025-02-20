package junit.sample;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class DateExampleTest{

	@Test
	public void testSetMessage() {
		final LocalDateTime current = LocalDateTime.now();
		DateExample sut = new DateExample() {
			@Override
			public LocalDateTime newDate() {
				return current;
			}
		};
		sut.setMessage();
		assertEquals("現在時刻:"+current, sut.getMessage());
	}


}
