package seo.dale.practice.java.io;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {
	@Test
	public void testSeparator() throws Exception {
		System.out.println(File.separator);
	}

    @Test
    public void testCreateTempFile() throws Exception {
	    File tempFile = File.createTempFile(getClass() + "-", ".dat");
        System.out.println(tempFile.getAbsolutePath());
        assertThat(tempFile.delete()).isTrue(); // should delete temp files.
    }
}
