package binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liju on 12/5/16.
 *
 Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

    1
  /   \
 2     3
  \
  5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class RootToLeafPaths {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths  = new LinkedList<>();
        return binaryTreePaths(root,paths);
    }

    public List<String> binaryTreePaths(TreeNode root,List<String> paths){

        //todo
        return null;
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
