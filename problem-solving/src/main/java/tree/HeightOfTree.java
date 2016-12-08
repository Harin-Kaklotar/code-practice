package tree;

/**
 * Created by Liju on 12/7/2016.
 *
 The height of a binary tree is the number of edges between the tree's root and its furthest leaf. This means that a tree containing a single node has a height of .

 Complete the getHeight function provided in your editor so that it returns the height of a binary tree. This function has a parameter, , which is a pointer to the root node of a binary tree.


 */
public class HeightOfTree {


    static int getHeight(Node root) {
        // Write your code here.
        if (root==null) return -1;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
