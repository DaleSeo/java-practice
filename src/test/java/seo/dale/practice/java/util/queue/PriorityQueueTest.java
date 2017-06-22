package seo.dale.practice.java.util.queue;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    private Queue<String> queue;

    @Test
    public void test() {
        queue = new PriorityQueue<>(3);
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");

        System.out.println("#queue: " + queue);
        System.out.println("#queue.size(): " + queue.size());
    }

}
