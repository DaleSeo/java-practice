package seo.dale.practice.java.util;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class CalendarTest {

	private Calendar calendar;
	
	@Before
	public void setUp() {
		calendar = Calendar.getInstance();
	}
	
	/**
	 * Calendar's getInstance method returns a Calendar object whose calendar fields have been initialized with the current date and time.
	 */
	@Test
	public void testGetInstance() {
		assertEquals(calendar.getTimeInMillis() / 1000, System.currentTimeMillis () / 1000);
	}
	
	@Test
	public void testGet() {
		int year = calendar.get(Calendar.YEAR);
		System.out.println("# Year : " + year);
		
		int month = calendar.get(Calendar.MONTH) + 1; // JANUARY is 0
		System.out.println("# Month : " + month);
		
		int dayOfMonth = calendar.get(Calendar.DATE);
		// int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("# Date (Day of Month) : " + dayOfMonth);
		
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // SUNDAY is 1
		System.out.println("# Day of Week : " + dayOfWeek);
		
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println("# HourOfDay : " + hourOfDay);
		
		int hour = calendar.get(Calendar.HOUR);
		System.out.println("# Hour : " + hour);

		int amPm = calendar.get(Calendar.AM_PM); // AM is 0
		System.out.println("# AM/PM : " + amPm);
		
		int minute = calendar.get(Calendar.MINUTE);
		System.out.println("# Minute : " + minute);
		
		int second = calendar.get(Calendar.SECOND);
		System.out.println("# Second : " + second);
	}
	
	@Test
	public void testSet() {
		Calendar englishCalendar = Calendar.getInstance(Locale.US); 
		System.out.println(englishCalendar.get(Calendar.DAY_OF_WEEK));
		
		Calendar frenchCalendar = Calendar.getInstance(Locale.FRANCE);
		System.out.println(frenchCalendar.get(Calendar.DAY_OF_WEEK));
	}
	
	@Test
	public void test3DaysLater() {
		System.out.println("# Current : " + calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		System.out.println("# 3 days later : " + calendar.getTime());
	}
	
	@Test
	public void test2MonthsEalier() {
		Calendar calendar = Calendar.getInstance();
		System.out.println("# Current : " + calendar.getTime());
		calendar.add(Calendar.MONTH, -2);
		System.out.println("# 2 month ealier : " + calendar.getTime());
	}
	
	@Test
	public void getLastDayOfMonth() {
		for (int i = 0; i < 12; i++) {
			Calendar calendar = new GregorianCalendar(2014, i, 1);
			int maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.println("# Max Day Of Month of " + (i + 1) + " : " + maxDayOfMonth);
		}
	}

}