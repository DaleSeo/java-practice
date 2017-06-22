package seo.dale.practice.java.util.collections.queue;

import java.util.*;

public class ItemFreqAnalyzer {

    private List<ItemFreq> itemFreqs;

    public ItemFreqAnalyzer(List<ItemFreq> itemFreqs) {
        this.itemFreqs = itemFreqs;
    }

    public List<ItemFreq> findTopN(int size) {
        Comparator<ItemFreq> comparator = Comparator
                .comparing(ItemFreq::getFreq)
                .thenComparing(ItemFreq::getItem);

        Queue<ItemFreq> queue = new PriorityQueue<>(size, comparator);

        itemFreqs.forEach(itemFreq -> {
            if (queue.size() < 3 || comparator.compare(queue.peek(), itemFreq) < 0) {
                queue.offer(itemFreq);
                while (queue.size() > 3) {
                    queue.poll();
                }
            }
        });

        LinkedList<ItemFreq> topN = new LinkedList<>();
        while (!queue.isEmpty()) {
            topN.addFirst(queue.poll());
        }

        return topN;
    }

    public static void main(String[] args) {
        List<ItemFreq> itemFreqs = Arrays.asList(
                new ItemFreq("무인기", 9),
                new ItemFreq("빅데이타", 10),
                new ItemFreq("자영업", 8),
                new ItemFreq("한류", 5),
                new ItemFreq("메이저리그", 7),
                new ItemFreq("강원도", 3),
                new ItemFreq("카페", 6)
        );

        ItemFreqAnalyzer analyzer = new ItemFreqAnalyzer(itemFreqs);
        List<ItemFreq> top3 = analyzer.findTopN(3);

        System.out.println("#top3: " + top3);
    }

}
