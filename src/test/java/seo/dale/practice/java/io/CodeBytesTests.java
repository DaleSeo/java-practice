package seo.dale.practice.java.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * http://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html
 */
public class CodeBytesTests {
	
	@Test
	public void test() {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("file/xanadu.txt");
			out = new FileOutputStream("file/outagain.txt");
			
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
