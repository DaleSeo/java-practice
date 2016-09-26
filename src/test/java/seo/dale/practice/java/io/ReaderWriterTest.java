package seo.dale.practice.java.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class ReaderWriterTest {

	@Test
	public void testRead() throws Exception {
		String text = "{\n" +
				"  \"id\": 101,\n" +
				"  \"title\": \"Response Body\",\n" +
				"  \"description\": \"응답 받아요 !@#$%^&*()-=\"\n" +
				"}";

		ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try (
				InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
				OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8)
		) {
			int c;
			while ((c = reader.read()) != -1) {
				System.out.println("- char : " + (char) c); // Cast to char
				writer.write(c);
			}
		}

		System.out.println("- String : " + out.toString());
		assertEquals(text, out.toString());
	}

	@Test
	public void testReadChunk() throws Exception {
		String text = "{\n" +
				"  \"id\": 101,\n" +
				"  \"title\": \"Response Body\",\n" +
				"  \"description\": \"응답 받아요 !@#$%^&*()-=\"\n" +
				"}";
		int length = 20;

		ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try (
				InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
				OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8)
		) {
			int c;
			while ((c = reader.read()) != -1 && length-- > 0) {
				System.out.println("- char : " + (char) c); // Cast to char
				writer.write(c);
			}
		}

		System.out.println("- String : " + out.toString());
		assertEquals(text.substring(0, 20), out.toString());
	}

}
