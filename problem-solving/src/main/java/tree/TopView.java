package tree;

/**
 * Created by Liju on 12/7/2016.
 You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
 You only have to complete the function.
 For example :

          3
        /   \
       5     2
      / \   / \
     1   4 6   7
      \       /
       9     8
 Top View : 1 -> 5 -> 3 -> 2 -> 7

 From the top only nodes 1,5,3,2 and 7 will be visible.

 */
public class TopView {

    void top_view(Node root) {
        if (root==null) return;
        printLeftNode(root.left);
        System.out.print(root.data+" ");
        printRightNode(root.right);
    }

    private void printRightNode(Node root) {
        if (root==null)return;
        System.out.print(root.data+" ");
        printRightNode(root.right);
    }

    private void printLeftNode(Node root) {
        if (root==null)return;
        printLeftNode(root.left);
        System.out.print(root.data+" ");
    }

    class Node {
        int data;
        Node left;
        Node right;
    }

}
