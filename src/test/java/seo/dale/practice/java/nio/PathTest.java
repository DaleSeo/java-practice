package seo.dale.practice.java.nio;

import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PathTest {

	/**
	 * Comparing Two Paths
	 */
	@Test
	public void testEquals() {
		Path path = Paths.get("/home/sally/foo");
		Path beginning = Paths.get("/home");
		Path ending = Paths.get("foo");

		assertTrue(Paths.get("/home/sally/foo").equals(path));
		assertTrue(path.startsWith(beginning));
		assertTrue(path.endsWith(ending));
	}

	/**
	 * Creating a Path Between Two Paths
	 */
	@Test
	public void testRelativize() {
		Path path1 = Paths.get("home");
		Path path2 = Paths.get("home/sally/bar");

		Path path1ToPath2 = path1.relativize(path2);
		System.out.println(path1ToPath2);
		assertEquals(Paths.get("sally/bar"), path1ToPath2);

		Path path2ToPath1 = path2.relativize(path1);
		System.out.println(path2ToPath1);
		assertEquals(Paths.get("../.."), path2ToPath1);
	}

	/**
	 * Joining Two Paths
	 */
	@Test
	public void testResolve() {
		Path path = Paths.get("/home/joe/foo");
		Path resultingPath = path.resolve("bar1/bar2");
		System.out.println(resultingPath);
		assertEquals(Paths.get("/home/joe/foo/bar/bar2"), resultingPath);
	}

	@Test
	public void testToAbsolutePath() {
		Path path = Paths.get("abc/def"); // relative path
		System.out.println(path.toAbsolutePath());
		assertEquals(Paths.get("D:/git/dale/dale-example/abc/def"), path);
	}

	@Test
	public void testToUri() {
		Path path = Paths.get("/git/study-jpa/README.md");
		System.out.println(path.toUri());
		assertEquals(URI.create("file:///D:/git/study-jpa/README.md"), path.toUri());
	}

	@Test
	public void testNormalize() {
		assertEquals(Paths.get("/home/joe/foo"), Paths.get("/home/./joe/foo").normalize());
		assertEquals(Paths.get("/home/joe/foo"), Paths.get("/home/sally/../joe/foo").normalize());
	}

    @Test
    public void test2() {
	    // It doesn't matter whether the file or directory exists.
	    Path path = Paths.get("D:/home/joe/foo");

	    System.out.format("toString : %s%n", path.toString());
	    // Returns the file name or the last element of the sequence of name elements.
	    System.out.format("getFileName : %s%n", path.getFileName());
	    // Returns the path element corresponding to the specified index. The 0th element is the path element closest to the root.
	    System.out.format("getName(0) : %s%n", path.getName(0));
	    // Returns the number of elements in the path.
	    System.out.format("getNameCount : %s%n", path.getNameCount());
	    // Returns the subsequence of the Path (not including a root element) as specified by the beginning and ending indexes.
	    System.out.format("subpath(0, 2) : %s%n", path.subpath(0, 2));
	    // Returns the path of the parent directory.
	    System.out.format("getParent : %s%n", path.getParent());
	    // Returns the root of the path. (Unix : /, Windows : C:\)
	    System.out.format("getRoot : %s%n", path.getRoot());
    }



    @Test
    public void test() {
        String rootDirectory = getClass().getResource("/").getPath(); // "/D:/workspace/dale-example/target/streaming-classes/" Why is there '/' at the beginning?
        Path rootPath = Paths.get(rootDirectory.substring(1));
        System.out.println("rootPath : " + rootPath);
        Stack<Path> stack = new Stack<>();
        stack.push(rootPath);

        while(!stack.isEmpty()) {
            Path currentPath = stack.pop();
            System.out.println(currentPath.toString());

            File currentFile = new File(currentPath.toString());

            if (currentFile.isDirectory()) {
                for (File file : currentFile.listFiles()) {
                    stack.push(file.toPath());
                }
            }
        }
    }

}
