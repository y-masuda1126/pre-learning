package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalcServiceTest {
    private CalcService calcService;

    @Test
    void test1() {
        var subResult = calcService.sub(100, 1);
        assertEquals(100, subResult);

        var divResult = calcService.div(100, 0);
        assertEquals(0, divResult);
    }
}
