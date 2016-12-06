package binaryTree;

/**
 * Created by liju on 12/5/16.
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 https://leetcode.com/problems/same-tree/


 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q!=null) return false;
        if (p!=null && q==null) return false;
        if (p==null && q==null) return true;
        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
