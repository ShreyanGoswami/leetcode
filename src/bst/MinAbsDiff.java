package bst;

/**
 * Leetcode 530 https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * Given the root of a BST, return the minimum absolute difference between the values of any two different nodes in the tree.
 */

public class MinAbsDiff {
    private int findRightMost(TreeNode curr) {
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.val;
    }

    private int findLeftMost(TreeNode curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.val;
    }

    private void minDiffHelper(TreeNode curr, int[] minDiff) {
        if (curr == null) return;
        int diff1 = Integer.MAX_VALUE;
        int diff2 = Integer.MAX_VALUE;
        if (curr.left != null) {
            diff1 = Math.abs(curr.val - findRightMost(curr.left));
        }
        if (curr.right != null) {
            diff2 = Math.abs(curr.val - findLeftMost(curr.right));
        }
        if (Math.min(diff1, diff2) < minDiff[0]) minDiff[0] = Math.min(diff1, diff2);
        minDiffHelper(curr.left, minDiff);
        minDiffHelper(curr.right, minDiff);
    }

    public int getMinimumDifference(TreeNode root) {
        int minDiff[] = new int[]{Integer.MAX_VALUE};

        minDiffHelper(root, minDiff);
        return minDiff[0];
    }
}
