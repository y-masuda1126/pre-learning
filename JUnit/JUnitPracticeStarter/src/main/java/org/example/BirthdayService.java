package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BirthdayService {
    private final LocalDate birthday;
    public BirthdayService(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        var today = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(birthday, today);
    }

    public boolean isBirthdayToday() {
        var today = LocalDate.now();

        return birthday.getMonth() == today.getMonth() && birthday.getDayOfMonth() == today.getDayOfMonth();
    }

}
