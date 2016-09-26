package seo.dale.practice.java.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;

public class FilesDirTest {

	@Test
	public void testCreateDirectories() throws Exception {
		Path path = Paths.get("/tmp/a/b/c");
		Files.createDirectories(path);
	}

	@Test
	public void testNewDirectoryStream() throws Exception {
		Path path = Paths.get("/git");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
			for (Path file: stream) {
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException ex) {
			System.err.println(ex);
		}
	}

}
