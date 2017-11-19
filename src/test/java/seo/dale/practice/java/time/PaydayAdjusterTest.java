package seo.dale.practice.java.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class PaydayAdjusterTest {
    @Test
    public void test1() {
        LocalDate date = Year.of(2013).atMonth(Month.JUNE).atDay(3);
        LocalDate nextPayday = date.with(new PaydayAdjuster());

        System.out.printf("Given the date: %s%n", date);
        System.out.printf("The next payday: %s%n", nextPayday);

        assertThat(LocalDate.of(2013, Month.JUNE, 14).isEqual(nextPayday));
    }

    @Test
    public void test2() {
        LocalDate date = Year.of(2013).atMonth(Month.JUNE).atDay(18);
        LocalDate nextPayday = date.with(new PaydayAdjuster());

        System.out.printf("Given the date: %s%n", date);
        System.out.printf("The next payday: %s%n", nextPayday);

        assertThat(LocalDate.of(2013, Month.JUNE, 28).isEqual(nextPayday));
    }
}