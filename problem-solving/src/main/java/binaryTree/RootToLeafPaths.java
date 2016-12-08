package binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liju on 12/5/16.
 * <p>
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 */
public class RootToLeafPaths {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        binaryTreePaths(root, paths, "");
        return paths;
    }

    public void binaryTreePaths(TreeNode root, List<String> paths, String str) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            paths.add(str + root.val + "");
            return;
        }
        binaryTreePaths(root.left, paths, str + root.val + "->");
        binaryTreePaths(root.right, paths, str + root.val + "->");
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
