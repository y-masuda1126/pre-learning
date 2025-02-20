package junit.sample;

import java.util.List;

public class Randoms {
	RandomNumber random = new RandomNumberImpl();

	public <T>T choice(List<T> options){
		if(options.size() == 0) {
			return null;
		}
		int index = random.nextInt() % options.size();
		return options.get(index);
	}

}
