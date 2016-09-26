package seo.dale.practice.java.nio;

import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * http://docs.oracle.com/javase/tutorial/essential/io/dirs.html
 */
public class FileSystemsTest {

	@Test
	public void testGetRootDirectories() throws Exception {
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		dirs.forEach(path -> System.out.println(path));
	}

}
