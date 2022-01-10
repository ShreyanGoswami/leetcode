package priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Leetcode 1046
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 *     If x == y, both stones are destroyed, and
 *     If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 *
 * At the end of the game, there is at most one stone left.
 *
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 */

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(stones.length, Collections.reverseOrder());
        for (int x: stones) pq.add(x);
        while (pq.size() > 1) {
            int f = pq.poll();
            int s = pq.poll();
            if (f==s) continue;
            else {
                pq.add(Math.abs(f-s));
            }
        }
        if (pq.size() == 1) return pq.poll();
        return 0;
    }
}
