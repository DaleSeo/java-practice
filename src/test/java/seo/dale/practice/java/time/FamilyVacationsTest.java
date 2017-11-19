package seo.dale.practice.java.time;

import org.junit.Test;

import java.time.LocalDate;

public class FamilyVacationsTest {
    @Test
    public void test() {
        LocalDate date = LocalDate.now();
        Boolean isFamilyVacation = date.query(new FamilyVacations());
        Boolean isFamilyBirthday = date.query(FamilyBirthdays::isFamilyBirthday);

        if (isFamilyVacation.booleanValue() || isFamilyBirthday.booleanValue())
            System.out.printf("%s is an important date!%n", date);
        else
            System.out.printf("%s is not an important date.%n", date);
    }
}