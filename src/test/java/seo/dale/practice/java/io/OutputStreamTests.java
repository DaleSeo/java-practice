package seo.dale.practice.java.io;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class OutputStreamTests {

	@Test
	public void test() throws Exception {
		PrintWriter out = null;
		try {
			String path = getClass().getResource("/file/OutputStreamTests.txt").getPath();
			out = new PrintWriter(new FileOutputStream(path));
			out.write(97);
			out.write(98);
			out.write(99);
			out.write(100);
			out.write(101);
			out.flush();
			System.out.println(out);
		} finally {
			if (out != null) out.close();
		}
	}

}
