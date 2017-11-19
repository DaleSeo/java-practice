package seo.dale.practice.java.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Birthday {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1982, Month.JULY, 13);

        periodIHaveLivedSoFar(today, birthday);
        periodUntilNextBDay(today, birthday);
    }

    private static void periodIHaveLivedSoFar(LocalDate today, LocalDate birthday) {
        Period p = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                " months, and " + p.getDays() +
                " days old. (" + p2 + " days total)");
    }

    private static void periodUntilNextBDay(LocalDate today, LocalDate birthday) {
        LocalDate nextBDay = birthday.withYear(today.getYear());
        if (!nextBDay.isAfter(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);

        System.out.println("There are " + p.getMonths() + " months, and " +
                p.getDays() + " days until your next birthday. (" +
                p2 + " days total)");
    }
}
