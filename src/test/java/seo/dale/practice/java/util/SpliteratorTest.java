package seo.dale.practice.java.util;

import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.Callable;

public class SpliteratorTest {
    /***
     * https://www.journaldev.com/13521/java-spliterator
     */
    @Test
    public void testForEachRemaining() {
        List<String> names = Arrays.asList("Rams", "Posa", "Chinni");
        Spliterator<String> namesSpliterator = names.spliterator();
        namesSpliterator.forEachRemaining(System.out::println);
    }

    @Test
    public void testTryAdvance() {
        
    }

    @Data
    static class Article {
        private List<Author> listOfAuthors;
        private int id;
        private String name;
    }

    @Data
    static class Author {
        private String name;
        private int relatedArticleId;
    }

    static class Task implements Callable<String> {
        private Spliterator<Article> spliterator;
        private final static String SUFFIX = "- published by Baeldung";

        public Task(Spliterator<Article> spliterator) {
            this.spliterator = spliterator;
        }


        @Override
        public String call() {
            int current = 0;
            while (spliterator.tryAdvance(article -> {
                article.setName(article.getName().concat(SUFFIX));
            })) {
                current++;
            }
            return Thread.currentThread().getName() + ":" + current;
        }
    }
}
