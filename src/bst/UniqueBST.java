package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 96 https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 */
public class UniqueBST {

    public int numTrees(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3;i<=n;i++) {
            int total = 0;
            for (int j=1;j<=i;j++) {
                total += dp[j-1] * dp[i-j];
            }
            dp[i] = total;
        }
        return dp[n];
    }
}
