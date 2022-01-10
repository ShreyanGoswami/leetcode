package priorityqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode 347 https://leetcode.com/problems/top-k-frequent-elements/
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */

public class KFrequentElements {
    class Pair {
        int f, s;
        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x: nums) {
            if (m.containsKey(x)) {
                m.put(x, m.get(x) + 1);
            } else {
                m.put(x, 1);
            }
        }
        Comparator<Pair> pairComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair s1, Pair s2) {
                return s2.s - s1.s;
            }
        };
        PriorityQueue<Pair> pq = new PriorityQueue(m.size(), pairComparator);
        for (Map.Entry<Integer, Integer> e: m.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
        }
        int res[] = new int[k];
        for (int i=0;i<k;i++) {
            res[i] = pq.poll().f;
        }
        return res;
    }
}
