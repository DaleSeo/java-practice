package seo.dale.practice.java.io;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * http://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
 */
public class CodeCharectersTests {
	
	@Test
	public void test() {
		FileReader in = null;
		FileWriter out = null;
		
		try {
			in = new FileReader("file/xanadu.txt");
			out = new FileWriter("file/characteroutput.txt");
			
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) in.close();
				if (out != null) out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
