package priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        for (int x: nums) pq.add(x);
        for (int i=0;i<k-1;i++) {
            pq.poll();
        }
        return pq.poll();
    }
}
