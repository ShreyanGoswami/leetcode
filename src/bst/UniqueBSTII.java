package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 95 https://leetcode.com/problems/unique-binary-search-trees-ii/
 *
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n.
 * Return the answer in any order.
 */
public class UniqueBSTII {

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> roots = new ArrayList<>();
        if (start == end) {
            roots.add(new TreeNode(start));
            return roots;
        }
        if (start > end) {
            roots.add(new TreeNode(-1));
            return roots;
        }

        for (int i=start;i<=end;i++) {
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode root = new TreeNode(i);
                    if (l.val == -1) {
                        root.left = null;
                    } else {
                        root.left = l;
                    }

                    if (r.val == -1) {
                        root.right = null;
                    } else {
                        root.right = r;
                    }
                    roots.add(root);
                }
            }
        }
        return roots;
    }

    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
}
