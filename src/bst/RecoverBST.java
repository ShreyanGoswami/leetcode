package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 99 https://leetcode.com/problems/recover-binary-search-tree/
 *
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 */

public class RecoverBST {

    void inorder(TreeNode curr, List<TreeNode> arr) {
        if (curr == null) return;
        inorder(curr.left, arr);
        arr.add(curr);
        inorder(curr.right, arr);
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> temp = new ArrayList<>(0);
        inorder(root, temp);
        int l = temp.size();
        int count = 0;
        int first = 0, second = 0;
        for (int i=1;i<l;i++) {
            if (temp.get(i).val < temp.get(i-1).val) {
                count++;
                if (count == 1) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }

        int t = temp.get(first-1).val;
        if (count == 1) {
            temp.get(first-1).val = temp.get(first).val;
            temp.get(first).val = t;
        } else {
            temp.get(first-1).val = temp.get(second).val;
            temp.get(second).val = t;
        }
    }
}
