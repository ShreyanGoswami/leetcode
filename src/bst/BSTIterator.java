package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 173 https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {
    private List<Integer> nodes;
    private int index = 0;

    public BSTIterator(TreeNode root) {
        this.nodes = new ArrayList<Integer>();
        inorder(root);
    }

    private void inorder(TreeNode curr) {
        if (curr == null) return;
        inorder(curr.left);
        this.nodes.add(curr.val);
        inorder(curr.right);
    }

    public int next() {
        int v = nodes.get(index);
        index++;
        return v;
    }

    public boolean hasNext() {
        return index < nodes.size();
    }
}
