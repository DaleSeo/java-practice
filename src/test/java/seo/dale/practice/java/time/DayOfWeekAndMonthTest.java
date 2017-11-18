package seo.dale.practice.java.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://docs.oracle.com/javase/tutorial/datetime/iso/enum.html
 */
public class DayOfWeekAndMonthTest {
    @Test
    public void testGetDisplayName() {
        DayOfWeek dow = DayOfWeek.TUESDAY;

        assertThat(dow.getDisplayName(TextStyle.FULL, Locale.US)).isEqualTo("Tuesday");
        assertThat(dow.getDisplayName(TextStyle.NARROW, Locale.US)).isEqualTo("T");
        assertThat(dow.getDisplayName(TextStyle.SHORT, Locale.US)).isEqualTo("Tue");

        assertThat(dow.getDisplayName(TextStyle.FULL, Locale.KOREA)).isEqualTo("화요일");
        assertThat(dow.getDisplayName(TextStyle.NARROW, Locale.KOREA)).isEqualTo("화");
        assertThat(dow.getDisplayName(TextStyle.SHORT, Locale.KOREA)).isEqualTo("화");
    }

    @Test
    public void testMaxLength() {
        assertThat(Month.JANUARY.maxLength()).isEqualTo(31);
        assertThat(Month.FEBRUARY.maxLength()).isEqualTo(29);
    }

    @Test
    public void testMonthDisplayName() {
        Month month = Month.JULY;

        assertThat(month.getDisplayName(TextStyle.FULL, Locale.US)).isEqualTo("July");
        assertThat(month.getDisplayName(TextStyle.NARROW, Locale.US)).isEqualTo("J");
        assertThat(month.getDisplayName(TextStyle.SHORT, Locale.US)).isEqualTo("Jul");

        assertThat(month.getDisplayName(TextStyle.FULL, Locale.KOREA)).isEqualTo("7월");
        assertThat(month.getDisplayName(TextStyle.NARROW, Locale.KOREA)).isEqualTo("7월");
        assertThat(month.getDisplayName(TextStyle.SHORT, Locale.KOREA)).isEqualTo("7월");
    }
}
