package bst;

/**
 * Leetcode 938 https://leetcode.com/problems/range-sum-of-bst/
 *
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 */

public class RangeSum {

    void rangeSumHelper(TreeNode curr, int[] sum, int low, int high) {
        if (curr == null) return;

        if (curr.val >= low && curr.val <= high) sum[0] += curr.val;
        rangeSumHelper(curr.left, sum, low, high);
        rangeSumHelper(curr.right, sum, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum[] = new int[]{0};
        rangeSumHelper(root, sum, low, high);
        return sum[0];
    }
}
