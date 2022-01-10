package bst;

/**
 * Leetcode 701 https://leetcode.com/problems/insert-into-a-binary-search-tree/ ,
 * Leetcode 450 https://leetcode.com/problems/delete-node-in-a-bst/
 */

public class BST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        helper(root, val);
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) {
            root.left = deleteNode(root.left, val);
        } else if (root.val < val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode succ = getSuccessor(root);
            root.val = succ.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private void helper(TreeNode curr, int val) {
        if (curr.left == null && curr.val > val) {
            curr.left = new TreeNode(val);
            return;
        } else if (curr.right == null && curr.val < val) {
            curr.right = new TreeNode(val);
            return;
        }

        if (curr.val > val) helper(curr.left, val);
        else helper(curr.right, val);
    }

    private TreeNode getSuccessor(TreeNode curr) {
        if (curr == null) return null;
        TreeNode temp = curr.right;
        while (temp.left != null) temp = temp.left;
        return temp;
    }
}
