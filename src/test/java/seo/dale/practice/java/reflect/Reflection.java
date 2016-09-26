package seo.dale.practice.java.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

import static junit.framework.Assert.assertEquals;

public class Reflection {

    @Test
    public void testUpdateField() throws Exception {
        final BookRecord record = new BookRecord("author1", "title1");
        final Field author = record.getClass().getDeclaredField("author");
        author.setAccessible(true); // private, final 모두 불능화 시킴
        author.set(record, "author2");
        assertEquals("author2", record.getAuthor());
    }

}

class BookRecord {

    private final String author;
    private final String bookTitle;

    public BookRecord(String author, String bookTitle) {
        this.author = author;
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

}
