package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaxAmountServiceTest {

	@Mock
	private TaxService taxService;

	@Captor
	private ArgumentCaptor<LocalDate> dateCaptor;

	@InjectMocks
	private TaxAmountService taxAmountService;

    @Test
    @DisplayName("消費税率8%で端数切捨ての場合")
    public void test1() {

    	when(taxService.getTaxRate(any())).thenReturn(BigDecimal.valueOf(8));
    	var taxAmount1 = taxAmountService.getTaxAmount(106, LocalDate.of(2019, 9, 30));
//    	System.out.println("taxAmount1:" + taxAmount1); // 確認用に出力した
    	assertEquals(8, taxAmount1);

    	verify(taxService, times(1)).getTaxRate(any());

    }

    @Test
    @DisplayName("消費税率8%で端数切り上げの場合")
    public void test2() {
//        // スタブの設定(doReturnを使用)
//        doReturn(BigDecimal.valueOf(8)).when(taxService).getTaxRate(any());
//        var taxAmount = taxAmountService.getTaxAmount(107, LocalDate.of(2019, 9, 30));
//        // 戻り値の検査
//        assertEquals(9, taxAmount);
//
//        verify(taxService).getTaxRate(dateCaptor.capture());
//
//        assertEquals(LocalDate.of(2019, 9, 30), dateCaptor.getValue());
    }

    @Test
    @DisplayName("消費税率10%の場合")
    public void test3() {
//        // スタブの設定
//        when(taxService.getTaxRate(any())).thenReturn(BigDecimal.TEN);
//        var taxAmount = taxAmountService.getTaxAmount(105, LocalDate.of(2019, 10, 1));
//        // 戻り値の検査
//        assertEquals(11, taxAmount);
    }

    @Test
    @DisplayName("課税対象額が0の場合")
    public void test4() {
//        var taxAmount = taxAmountService.getTaxAmount(0, LocalDate.of(2019, 9, 30));
//        // 戻り値の検査
//        assertEquals(0, taxAmount);
//        // taxServiceの呼び出し回数の検査(課税対象額が0の場合は呼び出されていないはず)
//        verify(taxService, never()).getTaxRate(any());
    }
}
