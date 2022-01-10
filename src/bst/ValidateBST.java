package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 98 https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {

    private void inorder(TreeNode curr, List<Integer> arr) {
        if (curr == null) return;
        inorder(curr.left, arr);
        arr.add(curr.val);
        inorder(curr.right, arr);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        int prev = res.get(0);
        int l = res.size();
        for (int i=1;i<l;i++) {
            if (res.get(i) <= prev) return false;
            prev = res.get(i);
        }
        return true;
    }
}
