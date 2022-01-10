package disjointsetunion;

import java.util.HashMap;
import java.util.Map;

/** Leetcode 128 https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        // declare a hashmap to map numbers to integers smaller than it
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        int id = 0;
        for (int x: nums) {
            if (m.containsKey(x)) continue;
            m.put(x, m.getOrDefault(x, id++));
        }

        // declare a union find ds whose size is the size of the set
        UnionFind uf = new UnionFind(m.size());
        // iterate over the list of numbers
        for (int x: nums) {
            // if curr - 1 exist join
            if (m.containsKey(x-1)) {
                // add numbers that are differing by 1 into the same group
                uf.union(m.get(x-1), m.get(x));
            }
            // if curr + 1 exist join
            if (m.containsKey(x+1)) {
                // add numbers that are differing by 1 into the same group
                uf.union(m.get(x), m.get(x+1));
            }
        }
        // return max size out of all sizes
        return uf.getMaxSize();
    }
}
