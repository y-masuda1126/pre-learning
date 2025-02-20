package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
	private final BigDecimal ONE_HUNDRED = new BigDecimal(100);

	public int add(int x, int y) { //足し算
		return x + y;
	}

	public int sub(int x, int y) { //引き算
		return x - y;
	}

	public int mul(int x, int y) { //掛け算
		return x * y;
	}

	public float div(int x, int y) { //割り算
		if (y == 0)
			throw new IllegalArgumentException("第二引数に0が指定されました");

		return (float) x / (float) y;
	}

	/**
	 * 税込金額を計算
	 * 1章演習：例外を送出するメソッドのテストで利用します
	 *
	 * @param price 課税対象額
	 * @return 税込金額
	 */
	public int taxPrice(int price) {
		if (price < 0)
			throw new IllegalArgumentException("価格は0円以上にしてください");
		var basePrice = new BigDecimal(price);
		var taxRate = new BigDecimal("0.1");
		var tax = basePrice.multiply(taxRate).setScale(0, RoundingMode.DOWN);
		return basePrice.add(tax).intValue();

	}

	/**
	 * 税込金額を計算
	 * ２章演習:パラメータ化テストで利用します
	 *
	 * @param rate 税率
	 * @param price 課税対象額
	 * @return 税込金額
	 */
	public int taxPrice(int rate, int price) {
		var basePrice = new BigDecimal(price);
		var taxRate = new BigDecimal(rate).divide(ONE_HUNDRED, 2, RoundingMode.DOWN);
		var tax = basePrice.multiply(taxRate).setScale(0, RoundingMode.DOWN);
		return basePrice.add(tax).intValue();
	}
}
