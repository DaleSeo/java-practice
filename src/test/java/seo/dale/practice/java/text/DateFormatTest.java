package seo.dale.practice.java.text;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {

	@Test
	public void testFormat() {
		DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String dateText = formatter.format(new Date());
		System.out.println(dateText);
	}
	
	@Test
	public void testDefaultFormat() {
		DateFormat formatter = DateFormat.getDateTimeInstance();
		String dateText = formatter.format(new Date());
		System.out.println(dateText);
	}
	
	@Test
	public void testDefaultFullFormat() {
		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
		String dateText = formatter.format(new Date());
		System.out.println(dateText);		
	}
	
	@Test
	public void convertFormatFromEnglishtoKorean() throws ParseException {
		String englishText = "Saturday, September 13, 2014 12:15:23 PM KST";
		DateFormat englishFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US);
		Date date = englishFormat.parse(englishText);
		
		DateFormat koreanFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.KOREA);
		String koreanText = koreanFormat.format(date);
		
		System.out.println("# English Text : " + englishText);
		System.out.println("# Korean Text : " + koreanText);
	}
	
}
