package seo.dale.practice.java;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    @Test
    public void test() {
        String filePath = getClass().getResource("/log4j.xml").getPath();
        try (FileReader reader = new FileReader(filePath)) {
            char[] buffer = new char[512];
            reader.read(buffer);
            System.out.println(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
