package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode 239 https://leetcode.com/problems/sliding-window-maximum/
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 */

public class SlidingWindowMaximum {

    class Pair {

        int f, s;
        Pair(int first, int second) {
            this.f = first;
            this.s = second;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Comparator<Pair> cmp = (final Pair p1, final Pair p2) ->  p2.f - p1.f;
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, cmp);
        int i = 0;
        int l = nums.length;
        int res[] = new int[l-k+1];
        // Add the first k elements
        while (i < k) {
            pq.add(new Pair(nums[i], i));
            i++;
        }
        i = 0;
        res[i++] = pq.peek().f;
        int left = 1;
        int curr = k;
        while (curr < l) {
            while (!pq.isEmpty() && pq.peek().s < left) { // the index of maximum can be greater than or equal to left
                pq.poll();
            }
            pq.add(new Pair(nums[curr],curr));
            res[i++] = pq.peek().f;
            curr++;
            left++;
        }
        return res;
    }
}
