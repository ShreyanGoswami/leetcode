package priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Leetcode 378 https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * You must find a solution with a memory complexity better than O(n2).
 */

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        int n = matrix.length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) pq.poll();
            }
        }
        return pq.peek();
    }
}
