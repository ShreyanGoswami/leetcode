package bst;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode 653 https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 */

public class TwoSumIV {

    private void findTargetHelper(TreeNode curr, Set<Integer> visited, int k) {
        if (curr == null) return;

        visited.add(curr.val);
        findTargetHelper(curr.left, visited,k);
        findTargetHelper(curr.right, visited, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();
        findTargetHelper(root, s, k);
        if (s.size() == 1) return false;
        for (int x: s) {
            if ((k-x) != x && s.contains(k-x)) return true;
        }
        return false;
    }
}
