package binaryTree;

/**
 * Created by liju on 12/6/16.
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * - The left subtree of a node contains only nodes with keys less than the node's key. - The right subtree of a node
 * contains only nodes with keys greater than the node's key. - Both the left and right subtrees must also be binary
 * search trees.
 * 
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        return (min == null || root.val > min) && (max == null || root.val < max) && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
