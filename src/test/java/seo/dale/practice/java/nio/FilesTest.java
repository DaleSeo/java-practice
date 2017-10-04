package seo.dale.practice.java.nio;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.*;

public class FilesTest {

	@Test
	public void testWriteAndReadText() throws IOException {
		Path path = Paths.get("D:/tmp/streaming.txt");
		Charset charset = Charset.forName("UTF-8");
		String content = "이름 :\n\t서대영\n나이 :\n\t34";

		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			writer.write(content, 0, content.length());
		}

		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	@Test
	public void testWriteAndRead() throws IOException {
		String content = "12345";
		byte[] input = content.getBytes();

		Path path = Paths.get("D:/tmp/streaming.txt");
		Files.write(path, input);

		byte[] output = Files.readAllBytes(path);
		assertArrayEquals(input, output);
	}

	@Test
	public void testMetadata() throws IOException {
		Path path = Paths.get("D:/tmp/streaming.txt");
		BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);

		System.out.println("- creationTime : " + attributes.creationTime());
		System.out.println("- lastAccessTime : " + attributes.lastAccessTime());
		System.out.println("- lastModifiedTime : " + attributes.lastModifiedTime());

		System.out.println("- isDirectory : " + attributes.isDirectory());
		System.out.println("- isOther : " + attributes.isOther());
		System.out.println("- isRegularFile : " + attributes.isRegularFile());
		System.out.println("- isSymbolicLink : " + attributes.isSymbolicLink());
		System.out.println("- size : " + attributes.size());
	}

	/**
	 * http://docs.oracle.com/javase/tutorial/essential/io/copy.html
	 */
	@Test
	public void testCopy() throws IOException {
		Path source = Paths.get("D:/tmp/streaming.txt");
		Path target = Paths.get("D:/tmp/streaming-1.txt");
		Files.copy(source, target, REPLACE_EXISTING);
	}

	@Test
	public void testCopyFromStream() throws IOException {
		String content = "abcde";
		InputStream input = new ByteArrayInputStream(content.getBytes());
		Path target = Paths.get("D:/tmp/streaming-1.txt");
		Files.copy(input, target, REPLACE_EXISTING);
	}

	@Test
	public void testExists() {
		Path path = Paths.get("D:/git/dale/README.md");
		assertTrue(Files.exists(path));
		assertFalse(Files.notExists(path));
	}

	@Test
	public void testAble() {
		Path path = Paths.get("D:/git/dale/README.md");
		assertTrue(Files.isReadable(path));
		assertTrue(Files.isWritable(path));
		assertTrue(Files.isExecutable(path));
	}

	@Test
	public void testIsSameFile() throws IOException {
		Path path = Paths.get("C:\\Program Files\\Git\\git-bash.exe");
		Path shortcut = Paths.get("C:\\Users\\Dale\\Desktop\\Git Bash.lnk");
		assertTrue(Files.exists(path));
		assertTrue(Files.exists(shortcut));
		assertFalse(Files.isSameFile(path, shortcut));
	}

	@Test
	public void testDelete() throws IOException {
		Path path = Paths.get("D:/git/dale/README - 1.md");
		Files.delete(path);
		assertFalse(Files.deleteIfExists(path));
	}

}
