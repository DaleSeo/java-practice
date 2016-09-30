package seo.dale.practice.java.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Scanner;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class ScannerTest {

	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	// @Ignore
	@Test
	public void test() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your age in years: ");
		double age = input.nextDouble();
		System.out.println("Enter your maximum heart rate: ");
		double rate = input.nextDouble();
		double fb = (rate - age) * 0.65;
		System.out.println("Year ideal fat-burning heart rate is " + fb);
		input.close();
	}

}
