package tree.bst;

/**
 * Created by liju on 4/12/16.
 */
public class CheckBST {

    private Node root;

    public static void main(String[] args) {
         /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80
       */

        CheckBST checkBST = new CheckBST();
        checkBST.root = new Node(50);
        checkBST.root.left = new Node(30);
        checkBST.root.right = new Node(70);
       checkBST.root.left.left = new Node(20);
        checkBST.root.left.right = new Node(40);
        checkBST.root.right.left = new Node(60);
        checkBST.root.right.right = new Node(80);

        System.out.println("is tree BST  ? "+checkBST.isBSTUtil());

    }

    private boolean isBSTUtil() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int minValue, int maxValue) {
        /* an empty tree is BST */
        if (root ==  null)
            return true;
        /* false if this node violates the min/max constraints */
        if (root.data < minValue || root.data > maxValue)
            return false;
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBST(root.left,minValue,root.data-1)&& isBST(root.right,root.data+1,maxValue));

    }

}
class Node {
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
