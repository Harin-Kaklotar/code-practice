package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree, is a node-based binary tree data structure which has the following properties: The left subtree
 * of a node contains only nodes with keys less than the node’s key. The right subtree of a node contains only nodes
 * with keys greater than the node’s key. The left and right subtree each must also be a binary search tree. There must
 * be no duplicate nodes.
 *
 *
 * Class contains  - insert and traversal operations for BST
 * Created by liju on 4/10/16.
 */
public class BinarySearchTree {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRecur(data, root);
    }

    private Node insertRecur(int data, Node root) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRecur(data, root.left);

        } else if (data > root.data) {
            root.right = insertRecur(data, root.right);
        }
        return root;
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    private void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

    }

    private void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }

    }

    /**
     * Deleting node in BST
     *
         1) Node to be deleted is leaf: Simply remove from the tree.

            50                            50
         /     \         delete(20)      /   \
         30      70       --------->    30     70
         /  \    /  \                     \    /  \
       20   40  60   80                   40  60   80

         2) Node to be deleted has only one child: Copy the child to the node and delete the child

            50                            50
         /     \         delete(30)      /   \
         30      70       --------->    40     70
         \    /  \                          /  \
         40  60   80                       60   80

         3) Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor.
            Note that inorder predecessor can also be used.

             50                            60
          /     \         delete(50)      /   \
         40      70       --------->    40    70
         /  \                            \
        60   80                           80

         The important thing to note is, inorder successor is needed only when right child is not empty. In this particular case, inorder successor can be obtained by finding the minimum value in right child of the node.
         *
     */
    //TODO
    public Node delete(int data, Node root){
        //tree is empty
        if (root == null)
            return null;

        if (data<root.data)
            delete(data,root.left);
        else if (data>root.data)
            delete(data,root.right);
        else {
            //we found the data to be deleted

        }
        return null;
    }

    /**
     * Method to get minimum value in the given tree
     * @param root
     * @return
     */
    public int minimumValue (Node root){
        //empty tree
        if (root==null)
            return -99999;

        if (root.left==null)
            return root.data;
         return minimumValue(root.left);
    }

    /**
     * Retrieves Height of the given  bst
     * @param root
     * @return
     */
    public int height(Node root){
        if (root==null){
            return 0;//empty tree
        }
        else {
            //compute high of left and right trees
            int lht = height(root.left);
            int rht = height(root.right);

            if (lht > rht)
                return  lht+1;
            else
                return rht+1;
        }
    }

    /**
     * Breadth first traversal for a tree - Method 1
     * @param root
     */
    public void levelOrderTraversalUsingQueue(Node root){
        //visit each node and put the child in queue
        Queue<Node> queue = new LinkedList<>();
        if (root==null)
            return;
       queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
    }

    /**
     * Breadth first traversal for a tree - Method 2
     * @param root
     */
    public void levelOrderTraversalUsingRecursion(Node root){

        //empty tree
       if (root==null)
            return;
        for (int level = 1; level <= height(root); level++) {
            printAllNodesAtLevel(root,level);
        }
    }

    /**
     * Prints all nodes at given level
     * @param root
     * @param level
     */
    private void printAllNodesAtLevel(Node root,int level) {
        if (root==null)
            return;
        if (level==1)
            System.out.print(root.data+" ");
        else if(level>1){
            printAllNodesAtLevel(root.left, level - 1);
            printAllNodesAtLevel(root.right,level-1);
        }

    }

    /**
     * You need to find the inorder successor and predecessor of a given key.
     * In case the given key is not found in BST, then return the two values within which this key will lie.
     * @param root
     */
    private Node predecessor,successor;
    public void printPreSucc(int key,Node root){
        //empty tree
        if (root==null)
            return;
        //if key is present
        if (key==root.data){
            // the maximum value in left subtree is predecessor
            if (root.left!=null) {
                Node tmp = root.left;
                while (tmp.right!=null){
                    tmp = tmp.right;
                }
                predecessor = tmp;
            }else {
                if (predecessor==null)
                    predecessor = root;
            }
            // the minimum value in right subtree is successor
            if (root.right!=null) {
                Node tmp = root.right;
                while (tmp.left!=null){
                    tmp = tmp.left;
                }
                successor = tmp;
            }else {
                if (successor==null)
                    successor = root;
            }
            return;
        }
        // If key is smaller than root's key, go to left subtree
        else if (key < root.data) {
            successor = root;
            printPreSucc(key,root.left);
        }// else go to right subtree
        else if (key > root.data){
            predecessor = root;
            printPreSucc(key,root.right);
        }
    }

    /**
     * Method to find lowest common ancestor for given input
     * Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest
     * node in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).
     *
     * @param root
     * @return
     */
    public int lca(Node root,int minKey,int maxKey){
        //empty tree
        if (root==null)
            return  -1;
        //if both keys greater than root , move to right subtree
        if (root.data < minKey && root.data < maxKey)
            return  lca(root.right,minKey,maxKey);
        //if both keys less than root , move to left subtree
        else if (root.data > minKey && root.data > maxKey)
            return lca(root.left,minKey,maxKey);
        //else we found least common ancestor
        return root.data;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80
       */

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("inOrder - ");
        tree.inOrderTraversal(tree.root);
        System.out.print("\npreOrder - ");
        tree.preOrderTraversal(tree.root);
        System.out.print("\npostOrder - ");
        tree.postOrderTraversal(tree.root);

        // expected inOrder (LVR) = 20 30 40 50 60 70 80
        // expected preOrder (VLR) = 50 30 20 40 70 60 80
        // expected postOrder (LRV) = 20 40 30 60 80 70 50

        System.out.print("\nminimum value  -  " +tree.minimumValue(tree.root));

        System.out.println("\nHeight of the tree - "+tree.height(tree.root));

        System.out.print("\nLevel order traversal method 1 - " );
        tree.levelOrderTraversalUsingQueue(tree.root);

        System.out.print("\nLevel order traversal method 2 - " );
        tree.levelOrderTraversalUsingRecursion(tree.root);

        //predecessor & successor of given key
        tree.printPreSucc(52, tree.root);
        System.out.print("\npredecessor - " + tree.predecessor.data);
        System.out.print(" successor - "+tree.successor.data);
        tree.predecessor=null;tree.successor = null;
        tree.printPreSucc(70, tree.root);
        System.out.print("\npredecessor - "+tree.predecessor.data);
        System.out.print(" successor - "+tree.successor.data);

        //lease common ancestor
        System.out.println("\nleast common ancestor is - "+tree.lca(tree.root,20,60));
    }

}
