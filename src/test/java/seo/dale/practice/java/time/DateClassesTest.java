package seo.dale.practice.java.time;

import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://docs.oracle.com/javase/tutorial/datetime/iso/date.html
 */
public class DateClassesTest {
    @Test
    public void testLocalDate() {
        LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
        LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.printf("For the date of %s, the next Wednesday is %s.%n", date, nextWed);
    }

    @Test
    public void testYearMonth() {
        YearMonth date1 = YearMonth.of(2010, Month.FEBRUARY);
        assertThat(date1.lengthOfMonth()).isEqualTo(28);

        YearMonth date2 = YearMonth.of(2012, Month.FEBRUARY);
        assertThat(date2.lengthOfMonth()).isEqualTo(29);
    }

    @Test
    public void testMonthDay() {
        MonthDay date = MonthDay.of(Month.FEBRUARY, 29);
        assertThat(date.isValidYear(2010)).isFalse(); // 2010 is not a leap year
        assertThat(date.isValidYear(2012)).isTrue(); // 2012 is a leap year
    }

    @Test
    public void testYear() {
        assertThat(Year.of(2010).isLeap()).isFalse(); // 2010 is not a leap year
        assertThat(Year.of(2012).isLeap()).isTrue(); // 2012 is a leap year
    }
}
