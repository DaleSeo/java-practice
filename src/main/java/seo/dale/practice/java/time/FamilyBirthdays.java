package seo.dale.practice.java.time;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class FamilyBirthdays {
    public static Boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        if (month == Month.APRIL.getValue() && day == 3)
            return Boolean.TRUE;

        if (month == Month.JUNE.getValue() && day == 18)
            return Boolean.TRUE;

        if (month == Month.MAY.getValue() && day == 29)
            return Boolean.TRUE;

        return Boolean.FALSE;
    }
}
