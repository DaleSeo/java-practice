package seo.dale.practice.java.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * http://docs.oracle.com/javase/tutorial/essential/io/scanning.html
 */
public class ScanXanTests {

	@Test
	public void test() {
		Scanner s = null;
		
		try {
			s = new Scanner(new BufferedReader(new FileReader("file/xanadu.txt")));
			
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}

}
