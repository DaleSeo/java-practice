package seo.dale.practice.java.util.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {
    @Test
    public void testOf() {
        List<Integer> list = Stream.of(1, 2, 3)
                .collect(Collectors.toList());
        System.out.println(list);
        assertThat(list).contains(1, 2, 3);
    }
}
