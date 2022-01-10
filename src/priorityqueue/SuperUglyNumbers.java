package priorityqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 313 https://leetcode.com/problems/super-ugly-number/
 */

public class SuperUglyNumbers {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int res[] = new int[n+1];
        int pl = primes.length;
        int indices[] = new int[pl];
        for (int i=0;i<pl;i++) {
            indices[i] = 1;
        }
        res[1] = 1;
        for (int i=2;i<=n;i++) {
            int min = Integer.MAX_VALUE;
            List<Integer> toBeUpdated = new ArrayList<>(0);
            for (int j=0;j<pl;j++) {
                int curr = primes[j] * res[indices[j]];
                // System.out.println("Current: " + curr);
                if (curr < min) {
                    toBeUpdated.clear();
                    toBeUpdated.add(j);
                    min = curr;
                } else if (curr == min) {
                    toBeUpdated.add(j);
                }
            }
            res[i] = min;
            for (int k: toBeUpdated) {
                indices[k]++;
            }
        }
        return res[n];
    }
}
