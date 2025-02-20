package junit.sample;

import java.util.Random;

public class RandomNumberImpl implements RandomNumber{
	private final Random random = new Random();
	@Override
	public int nextInt() {
		return random.nextInt();
	}
}
