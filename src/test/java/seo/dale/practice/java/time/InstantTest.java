package seo.dale.practice.java.time;

import org.junit.Test;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://docs.oracle.com/javase/tutorial/datetime/iso/instant.html
 */
public class InstantTest {
    @Test
    public void testWthLocalDateTime() {
        Instant instant = Instant.now();
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Seoul"));
        assertThat(instant.equals(ldt.toInstant(ZoneOffset.of("+09:00")))).isTrue();
    }

    @Test
    public void testWithZonedDateTime() {
        Instant instant = Instant.now();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, ZoneId.of("Asia/Seoul"));
        assertThat(instant.equals(zdt.toInstant())).isTrue();
    }

    @Test
    public void testWithOffsetDateTime() {
        Instant instant = Instant.now();
        OffsetDateTime odt = OffsetDateTime.ofInstant(instant, ZoneOffset.of("+09:00"));
        assertThat(instant.equals(odt.toInstant())).isTrue();
    }
}
