package tree;

import java.util.*;

/**
 * Created by liju on 1/6/17.
 */
public class SwapNodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();

        Tree tree = new Tree();

        for (int i = 1; i <= n; i++) {
            tree.add(sc.nextInt(),sc.nextInt());
        }

        final int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            tree.swap(sc.nextInt());
            tree.inOrderTraversal();
        }

    }


    private static class Tree{

        private static Queue<Node> queue = new LinkedList<>();
        private static class Node{
            int index;
            Node left;
            Node right;

            public Node(int index) {
                this.index = index;
            }
        }

        static private Node root=new Node(1);
        static {
            queue.add(root);
        }

        public void add(int left ,int right){
            final Node node = queue.poll();
            node.left = new Node(left);
            node.right = new Node(right);
            queue.offer(node.left);
            queue.offer(node.right);
        }

        public void inOrderTraversal() {
            inOrderTraversalRecur(root);
            System.out.print("\n");
        }

        private void inOrderTraversalRecur(Node root) {
            if (root.index==-1) return;
            inOrderTraversalRecur(root.left);
            System.out.print(root.index+" ");
            inOrderTraversalRecur(root.right);
        }

        public void swap(int k){
            int maxDepth  = maxDepthOfTree(root);
            for (int i = 1; ; i++) {
                final int t = i * k;
                if (t<=maxDepth) {
                    List<Node> nodes = nodesAtdepth(root,i * k);
                    for (Node node : nodes) {
                        swapChild(node);
                    }
                }else {
                    break;
                }
            }

        }

        private List<Node> nodesAtdepth(Node root, int depth) {
            List<Node> list = new ArrayList<>();
            nodesAtDepthRec(root, depth, list);
            return list;
        }

        private void nodesAtDepthRec(Node root, int depth,List<Node> list) {
            if (root==null) return;
            if (depth==1){
                list.add(root);
            }else {
                nodesAtDepthRec(root.left, depth - 1, list);
                nodesAtDepthRec(root.right, depth - 1, list);
            }
        }

        private int maxDepthOfTree(Node root) {
           return maxDepthRec(root, 1);
        }

        private int maxDepthRec(Node root, int i) {
            if (root.left==null) return i;
            //since it is a complete binary tree,traverse any branch
            return maxDepthRec(root.left, i + 1);
        }

        private void swapChild(Node node) {
            Node tmp =node.left;
            node.left=node.right;
            node.right = tmp;
        }
    }
}
