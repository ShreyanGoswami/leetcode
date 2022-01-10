package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 373 https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 */

public class KSmallestSums {
    class Pair {
        int f, s;
        Pair(int first, int second) {
            this.f = first;
            this.s = second;
        }
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Comparator<Pair> cpm = (final Pair p1, final Pair p2) -> (p2.f+p2.s) - (p1.f+p1.s);
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, cpm);

        for (int i=0;i<nums1.length;i++) {
            for (int j=0;j<nums2.length;j++) {
                int sum = nums1[i] + nums2[j];
                if (pq.size() == k && sum >= (pq.peek().f + pq.peek().s))  break;
                pq.add(new Pair(nums1[i], nums2[j]));
                // check this
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair t = pq.poll();
            List<Integer> temp = new ArrayList<>(2);
            temp.add(t.f);
            temp.add(t.s);
            res.add(temp);
        }
        return res;
    }
}
