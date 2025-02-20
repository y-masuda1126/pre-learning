package org.example;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BirthdayServiceTest {

    @Test
    void test() {
        var service = new BirthdayService(LocalDate.of(2000, 2, 10));

        // Mock化したインスタンス(mockDate)はcloseメソッドを実行し、閉じる必要があるため、
        // try with resource文でtry句を抜けたタイミングで自動的にcloseを実行するようにしています。
        try (MockedStatic<LocalDate> mockDate = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {

            // モックの設定(現在の日付を2020/2/10に設定
            var today = LocalDate.of(2020, 2, 10);
            mockDate.when(LocalDate::now).thenReturn(today);

            var age = service.getAge();

            //（１）getAgeのメソッド検証


            var birthdayToday = service.isBirthdayToday();

            //（２）isBirthdayTodyのメソッド検証


        }
    }

}
