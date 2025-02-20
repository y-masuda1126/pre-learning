package com.example.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class TaxAmountService {
    private static final BigDecimal ONEHUNDRED = BigDecimal.valueOf(100);

    private final TaxService taxService;

    public TaxAmountService(TaxService taxService) {
        this.taxService = taxService;
    }

    public int getTaxAmount(int baseAmount, LocalDate date) {
        if (baseAmount == 0) {
            return 0;
        }

        // 税率を取得
        var taxRate = taxService.getTaxRate(date);

        // 引数で渡された税抜金額と税率より税額を計算
        return BigDecimal.valueOf(baseAmount).multiply(taxRate)
                .divide(ONEHUNDRED, 0, RoundingMode.HALF_UP).intValue();
    }
}
