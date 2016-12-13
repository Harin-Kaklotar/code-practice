package bst;

import java.util.Scanner;

/**
 * Created by Liju on 12/11/2016.
 */
public class MedianUpdates {
    private static TreeNode root = null;

    public static TreeNode insert(TreeNode root,long val){
        if (root==null){
            TreeNode node = new TreeNode(val);
            node.ht = 0;
            node.rank =1;
            return node;
        }

        if (val>root.val){
            root.right = insert(root.right,val);
        }

        if (val<=root.val){
            root.left = insert(root.left,val);
        }

        return balanceOut(root);
    }

   /* public static boolean search(TreeNode root,long val){
        if (root==null) return false;
        if (val==root.val) return true;
        if (val >root.val){
            return search(root.right,val);
        }else {
            return search(root.left,val);
        }
    }*/
    public static TreeNode delete(TreeNode root ,long val,Bool found){
        if (root==null){
            return null;
        }

        if (val< root.val){
            root.left = delete(root.left,val,found);
        }
        if (val>root.val){
            root.right = delete(root.right,val,found);
        }

        if (val==root.val){
            found.setFound(true);
            //no-child
            if (root.left==null && root.right==null){
                return null;
            }
            //one-child
            if (root.left==null && root.right!=null){
                return root.right;
            }
            if(root.left!=null && root.right==null){
                return root.left;
            }
            //two-child
            TreeNode inOrderSuccessor  = getInOrderSuccessor(root);
            root.val = inOrderSuccessor.val;
            root.right = delete(root.right,inOrderSuccessor.val,found);
        }


        return balanceOut(root);
    }

    private static TreeNode balanceOut(TreeNode root) {
        root.ht = Math.max(height(root.left),height(root.right))+1;
        root.rank = calculateRank(root);

        int balanceFactor = balanceFactor(root);
        if (balanceFactor<-1 ||balanceFactor>1){
            if (balanceFactor>1){
                //left-left case
                if (balanceFactor(root.left)>0){
                    return rightRotate(root);
                }//left -right case
                else {
                    root.left = leftRotate(root.left);
                    return rightRotate(root);
                }
            }
            if (balanceFactor < -1){
                //right-right case
                if (balanceFactor(root.right)<0){
                    return leftRotate(root);
                }
                // right -left case
                else {
                    root.right=rightRotate(root.right);
                    return leftRotate(root);
                }
            }
        }
        return root;
    }


    public static double getMedian(TreeNode root,int leftRank,int rightRank){
        //final int rankDiff = calculateRank(root.left) - calculateRank(root.right);
        final int rankDiff = leftRank - rightRank;
        if (rankDiff==0) {
            return root.val;
        }
        else if (rankDiff==1){
            return (root.val+getRightMost(root.left))/2;
        }
        else if (rankDiff==-1){
            return (root.val+getLeftMost(root.right))/2;

        }
        else if(rankDiff > 1){
            //median is on left side
            final int i = calculateRank(root.left.right);
            int newRightRank = rightRank+1+i;
            int newLeftRank = leftRank-1-i;
            return getMedian(root.left,newLeftRank,newRightRank);
        }else {
            //median is on right side
            final int i = calculateRank(root.right.left);
            int newLeftRank = leftRank+1+i;
            int newRightRank = rightRank-1-i;
            return getMedian(root.right,newLeftRank,newRightRank);
        }
    }

    private static double getLeftMost(TreeNode root) {
        if (root.left==null) return root.val;
        return getRightMost(root.left);
    }

    private static double getRightMost(TreeNode root) {
        if (root.right==null) return root.val;
        return getRightMost(root.right);
    }

    private static StringBuilder printMedian(double median ,StringBuilder sb){
        if (median==(long)median){
            sb.append(String.format("%d",(long)median)+"\n");
        }else {
            sb.append(String.format("%.1f",median)+"\n");
        }

        return sb;

    }

    private static TreeNode getInOrderSuccessor(TreeNode root) {
        if (root.right.left!=null) return root.right.left;
        else return root.right;
    }


    private static TreeNode rightRotate(TreeNode root){
        TreeNode node  = root.left;
        root.left=node.right;
        node.right = root;
        //update heights and rank
        root.ht = Math.max(height(root.left),height(root.right))+1;
        root.rank = calculateRank(root);
        node.ht = Math.max(height(node.left),height(node.right))+1;
        node.rank = calculateRank(node);
        return node;
    }


    private static int calculateRank(TreeNode node){
        if (node==null) return 0;
        return calculateRank(node.left)+calculateRank(node.right)+1;
    }
    private static TreeNode leftRotate(TreeNode root){
        TreeNode node  = root.right;
        root.right=node.left;
        node.left = root;
        return node;
    }

    private static int balanceFactor(TreeNode root) {
        return height(root.left)-height(root.right);
    }

    private static int height(TreeNode root) {
        if (root==null) return -1;
        return Math.max(height(root.left),height(root.right))+1;
    }


    /* Tail starts here*/

    public static void main( String args[] ){


        Scanner in = new Scanner(System.in);

        int N;
        N = in.nextInt();

        String s[] = new String[N];
        int x[] = new int[N];

        for(int i=0; i<N; i++){
            s[i] = in.next();
            x[i] = in.nextInt();
        }

        median(s,x);
    }

    static void median(String a[],int x[]) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < a.length; i++) {
            switch (a[i].charAt(0)){
                case 'r' :
                    Bool found  = new Bool();
                    root = delete(root, x[i],found);
                    if (root==null||!found.getFound()) {
                        sb.append("Wrong!\n");
                    }else {
                        printMedian(getMedian(root,calculateRank(root.left),calculateRank(root.right)),sb);
                    }
                    break;
                case 'a' :
                    root = insert(root,x[i]);
                    printMedian(getMedian(root,calculateRank(root.left),calculateRank(root.right)),sb);
                    break;
                default: // do nothing

            }
        }
        System.out.print(sb.toString());
    }


    static class TreeNode{
        long val;
        int rank;
        int ht;
        TreeNode left;
        TreeNode right;
        TreeNode(long val){
            this.val=val;
        }
    }

    static class Bool{
        Boolean found = new Boolean(false);
        public void setFound(boolean found){
           this.found = found;
        }
        public boolean getFound(){
            return found;
        }
    }
}
