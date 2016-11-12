package seo.dale.practice.java.nio.stream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.mkyong.com/java8/java-8-stream-read-a-file-line-by-line/
 */
public class TestReadFileTest {

    @Test
    public void test1() throws URISyntaxException, IOException {
        String fileName = "file/lines.txt";

        URI uri = ClassLoader.getSystemResource(fileName).toURI();
        try (Stream<String> stream = Files.lines(Paths.get(uri))) {
            stream.forEach(System.out::println);
        }
    }


    @Test
    public void test2() throws URISyntaxException, IOException {
        List<String> list;

        String fileName = "file/lines.txt";

        URI uri = ClassLoader.getSystemResource(fileName).toURI();
        try (Stream<String> stream = Files.lines(Paths.get(uri))) {
            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
        }

        System.out.println(list);
    }

    @Test
    public void test3() throws URISyntaxException, IOException {
        List<String> list;

        String fileName = "file/lines.txt";

        URI uri = ClassLoader.getSystemResource(fileName).toURI();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(uri))) {
            list = br.lines().collect(Collectors.toList());
        }

        System.out.println(list);
    }

    @Test
    public void test4() throws URISyntaxException, IOException {
        String fileName = "file/lines.txt";

        URI uri = ClassLoader.getSystemResource(fileName).toURI();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(uri))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    @Test
    public void test5() throws URISyntaxException, IOException {
        String fileName = "file/lines.txt";

        InputStream in = ClassLoader.getSystemResourceAsStream(fileName);
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

}