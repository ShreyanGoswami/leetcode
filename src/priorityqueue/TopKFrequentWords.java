package priorityqueue;

import java.util.*;

/**
 * Leetcode 692 https://leetcode.com/problems/top-k-frequent-words/
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 */

public class TopKFrequentWords {

    class Pair {
        String f;
        int s;
        Pair(String f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> m = new HashMap<>();
        for (String word : words) {
            if (m.containsKey(word)) {
                m.put(word, m.get(word) + 1);
            } else {
                m.put(word, 1);
            }
        }
        Comparator<Pair> c = new Comparator<Pair>() {
            @Override
            public int compare(final Pair p1, final Pair p2) {
                if (p1.s == p2.s) {
                    return p2.f.compareTo(p1.f);
                }
                return p1.s - p2.s;
            }
        };
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, c);
        for (Map.Entry<String, Integer> e: m.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
            if (pq.size() > k) pq.poll();
        }
        List<String> topWords = new ArrayList<>();
        // Since the values are in a min heap and we want the highest frequency first as we poll the pq
        // we get larger and larger frequencies so we need to keep adding to the beginning of the list
        // or reverse the list at the end
        while (!pq.isEmpty()) {
            topWords.add(0, pq.poll().f);
        }
        return topWords;
    }
}
