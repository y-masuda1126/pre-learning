package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalcServiceTest {
	@Spy
    private CalcService calcService;

    @Test
    void test1() {
    	doReturn(0).when(calcService).div(100, 0);
        var subResult = calcService.sub(100, 1);
        assertEquals(99, subResult);

        var divResult = calcService.div(100, 0);
        assertEquals(0, divResult);
    }
}
