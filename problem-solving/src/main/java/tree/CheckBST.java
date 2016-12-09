package tree;

/**
 * Created by Liju on 12/8/2016.
 * <p>
 * Check  whether the given tree is valid BST
 * The  value of every node in a node's left subtree is less than the data value of that node.
 * The  value of every node in a node's right subtree is greater than the data value of that node.
 */
public class CheckBST {

    boolean checkBST(Node root) {
        return isBST(root, null, null);
    }

    boolean isBST(Node root, Integer min, Integer max) {
        if (root == null) return true;
        return (min == null || root.data > min) && (max == null || root.data < max)
                && isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
