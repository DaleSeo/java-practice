package seo.dale.practice.java.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileVisitorTest {

	@Test
	public void testWalkFileTree() throws Exception {
		Files.walkFileTree(Paths.get("/git"), new SimpleFileVisitor<Path>() {
			// Print information about
			// each type of file.
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
				if (attr.isSymbolicLink()) {
					System.out.format("Symbolic link: %s ", file);
				} else if (attr.isRegularFile()) {
					System.out.format("Regular file: %s ", file);
				} else {
					System.out.format("Other: %s ", file);
				}
				System.out.println("(" + attr.size() + "bytes)");
				return CONTINUE;
			}

			// Print each directory visited.
			@Override
			public FileVisitResult preVisitDirectory(Path dir,  BasicFileAttributes attrs) {
				System.out.format("Directory: %s%n", dir);
				return CONTINUE;
			}

			// If there is some error accessing
			// the file, let the user know.
			// If you don't override this method
			// and an error occurs, an IOException
			// is thrown.
			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) {
				System.err.println(exc);
				return CONTINUE;
			}
		});
	}
}
