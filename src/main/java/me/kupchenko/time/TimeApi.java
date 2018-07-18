package me.kupchenko.time;

import me.kupchenko.model.QualityAnnotations.Good;
import me.kupchenko.model.QualityAnnotations.Ugly;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class TimeApi {
    @Ugly
    class AddDayInLegacyJava {
        public Date tomorrow() {
            Calendar now = Calendar.getInstance();
            now.add(Calendar.DAY_OF_MONTH, 1);
            return now.getTime();
        }
    }

    @Ugly
    class AddDayInefficient {
        public LocalDate tomorrow() {
            return LocalDate.now().plus(1, DAYS);
        }
    }

    @Good
    class TheBestWayToAddDay {
        public LocalDate tomorrow() {
            return LocalDate.now().plusDays(1);
        }
    }
}