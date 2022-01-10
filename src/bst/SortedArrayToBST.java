package bst;

/**
 * Leetcode 108 https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */

public class SortedArrayToBST {

    TreeNode recurse(int low, int high, int[] nums) {
        if (low == high) return null;

        int mid = (low+high-1)>>1;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = recurse(low, mid, nums);
        curr.right = recurse(mid+1, high, nums);
        return curr;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int l = nums.length;
        TreeNode root = new TreeNode(nums[l>>1]);
        int mid = l >> 1;
        root.left = recurse(0, mid, nums);
        root.right = recurse(mid+1, l,nums);
        return root;
    }
}
