package seo.dale.practice.java.time;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * https://docs.oracle.com/javase/tutorial/datetime/iso/queries.html
 */
public class FamilyVacations implements TemporalQuery<Boolean> {
    @Override
    public Boolean queryFrom(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        if (month == Month.APRIL.getValue() && 3 <= day && day <=8)
            return Boolean.TRUE;

        if (month == Month.AUGUST.getValue() && 8 <= day && day <=14)
            return Boolean.TRUE;

        return Boolean.FALSE;
    }
}
