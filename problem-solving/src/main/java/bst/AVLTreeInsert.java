package bst;

/**
 * Created by Liju on 12/10/2016.
 * <p>
 * Insert a node to AVL tree
 */
public class AVLTreeInsert {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        //root.right=new Node(4);
        //root.right.right= new Node(5);

        insert(root, 7);
    }

    static Node insert(Node root, int val) {
        //empty tree case
        if (root == null) {
            root = new Node();
            root.val = val;
            root.ht = 0;
            return root;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        }
        if (val > root.val) {
            root.right = insert(root.right, val);
        }
        //update height of the root
        root.ht = height(root);
        int balancefactor = balanceFactor(root);
        if (balancefactor > 1 || balancefactor < -1) {
            //imbalanced root
            //left case
            if (balancefactor > 1) {
                //left-left case
                if (balanceFactor(root.left) > 0) {
                    return rightRotate(root);
                }// left -right case
                else {
                    root.left = leftRotate(root.left);
                    return rightRotate(root);
                }
            }
            //right case
            if (balancefactor < 1) {
                //right-right case
                if (balanceFactor(root.right) < 0) {
                    return leftRotate(root);
                }// right -left case
                else {
                    root.right = rightRotate(root.right);
                    return leftRotate(root);
                }
            }
        }
        return root;
    }


    private static Node leftRotate(Node root) {

        Node newNode = root.right;
        root.right = root.right.left;
        newNode.left = root;

        //update height
        root.ht = Math.max(height(root.left), height(root.right)) + 1;
        newNode.ht = Math.max(height(newNode.left), height(newNode.right)) + 1;
        return newNode;
    }


    private static Node rightRotate(Node root) {
        Node newNode = root.left;
        root.left = root.left.right;
        newNode.right = root;
        //update height
        root.ht = Math.max(height(root.left), height(root.right)) + 1;
        newNode.ht = Math.max(height(newNode.left), height(newNode.right)) + 1;
        return newNode;
    }

    static int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    static int height(Node node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static class Node {
        int val;   //Value
        int ht;      //Height
        Node left;   //Left child
        Node right;   //Right child

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

}
