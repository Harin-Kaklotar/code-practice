package bst;

/**
 * Created by Liju on 12/7/2016.
 * <p>
 You are given pointer to the root of the binary search tree and two values  v1 and v2 . You need to return the lowest common ancestor (LCA) of v1 and v2  in the binary search tree

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 */
public class LCA {

    static Node lca(Node root, int v1, int v2) {

        Node lca = null;
        while (root != null) {
            if (root.data > v1 && root.data > v2) {
                lca = root;
                root = root.left;
            } else if (root.data < v1 && root.data < v2) {
                lca = root;
                root = root.right;
            } else if ((root.data >= v1 && root.data <= v2) || (root.data <= v1 && root.data >= v2)) {
                lca = root;
                break;
            } else {
                break;
            }
        }
        return lca;
    }


    static Node recursiveLca(Node root, int v1, int v2) {
        //Decide if you have to call recursively
        //Samller than both
        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        }
        //Bigger than both
        if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        }
        //Else solution already found
        return root;
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
