package seo.dale.practice.java.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * http://docs.oracle.com/javase/tutorial/essential/io/buffers.html
 */
public class CodeLinesTests {
	
	@Test
	public void test() {
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new FileReader("file/xanadu.txt"));
			out = new PrintWriter(new FileWriter("file/characteroutput.txt"));
			
			String l;
			while ((l = in.readLine()) != null) {
				out.println(l);
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
