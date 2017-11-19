package seo.dale.practice.java.time;

import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class LegacyTest {
    @Test
    public void test1() {
        Date date = new Date();
        Instant instant = date.toInstant();
        assertThat(Date.from(instant)).isEqualTo(date);
    }

    @Test
    public void test2() {
        Instant instant = Instant.now();
        Date date = Date.from(instant);
        assertThat(date.toInstant()).isEqualTo(instant);
    }

    @Test
    public void test3() {
        Calendar calendar = Calendar.getInstance();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
        assertThat(GregorianCalendar.from(zdt).toInstant()).isEqualTo(calendar.toInstant());
    }

    @Test
    public void test4() {
        ZonedDateTime zdt = ZonedDateTime.now();
        GregorianCalendar calendar = GregorianCalendar.from(zdt);
        assertThat(calendar.toZonedDateTime().isEqual(zdt)).isTrue();
    }
}
