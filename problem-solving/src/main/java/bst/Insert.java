package bst;

/**
 * Created by Liju on 12/7/2016.
 */
public class Insert {

    static Node Insert(Node root, int value) {
        Node tmp = root;
        Node newNode = new Node();
        newNode.data = value;
        if (root == null) {
            root = newNode;
            return root;
        }
        while (tmp != null) {
            if (value < tmp.data) {
                if (tmp.left == null) {
                    tmp.left = newNode;
                    break;
                } else {
                    tmp = tmp.left;
                }
            } else if (value > tmp.data) {
                if (tmp.right == null) {
                    tmp.right = newNode;
                    break;
                } else {
                    tmp = tmp.right;
                }
            }

        }
        return root;
    }

    static class Node {
        int data;
        Node left;
        Node right;
    }
}
