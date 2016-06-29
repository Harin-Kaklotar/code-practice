package dp;

/**
 * Created by liju on 6/28/16.
 *
 *
 *  Given an array p[] which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i].
 *   We need to write a function MatrixChainOrder() that should return the minimum number of multiplications needed to multiply the chain.
 *
 *
 *    Input: p[] = {40, 20, 30, 10, 30}
 *  Output: 26000
 *  There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
 *  Let the input 4 matrices be A, B, C and D.  The minimum number of
 *  multiplications are obtained by putting parenthesis in following way
 *  (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
 *
 *  Input: p[] = {10, 20, 30, 40, 30}
 *  Output: 30000
 *  There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
 *  Let the input 4 matrices be A, B, C and D.  The minimum number of
 *  multiplications are obtained by putting parenthesis in following way
 *  ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
 *
 *  Input: p[] = {10, 20, 30}
 *  Output: 6000
 *  There are only two matrices of dimensions 10x20 and 20x30. So there
 *  is only one way to multiply the matrices, cost of which is 10*20*30
 *
 *
 * 1) Optimal Substructure:
 * A simple solution is to place parenthesis at all possible places,
 * calculate the cost for each placement and return the minimum value.
 * In a chain of matrices of size n, we can place the first set of parenthesis in n-1 ways.
 * For example, if the given chain is of 4 matrices. let the chain be ABCD,
 * then there are 3 way to place first set of parenthesis: A(BCD), (AB)CD and (ABC)D.
 * So when we place a set of parenthesis, we divide the problem into subproblems of smaller size.
 * Therefore, the problem has optimal substructure property and can be easily solved using recursion.
 *
 *
 *  ref - http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 */
public class MatrixChainMultiplication {

    /**
     * Naive recursive solution
     * @param p
     * @param startIndex
     * @param endIndex
     * @return
     */
    public int mtrxMultiplyRecursive(int[] p , int startIndex, int endIndex){

        if (startIndex+1 >= endIndex){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = startIndex+1; i < endIndex; i++) {

            int val  = mtrxMultiplyRecursive(p,startIndex,i)
                + mtrxMultiplyRecursive(p,i,endIndex)
                + p[startIndex]*p[i]*p[endIndex];

            if (val < min){
                min = val;
            }
        }

        return min;
    }

    /**
     * Solution using dp memoization
     * @param p
     * @param lookup
     * @param startIndex
     * @param endIndex
     * @return
     */
    public int mtxMultiplyDP(int[] p, int[][] lookup, int startIndex, int endIndex) {

        if (startIndex + 1 >= endIndex) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        if (lookup[startIndex][endIndex] == 0) {
            for (int i = startIndex + 1; i < endIndex; i++) {

                if (lookup[startIndex][i] == 0) {
                    lookup[startIndex][i] = mtxMultiplyDP(p, lookup, startIndex, i);
                }

                if (lookup[i][endIndex] == 0) {
                    lookup[i][endIndex] = mtxMultiplyDP(p, lookup, i, endIndex);
                }

                int val = lookup[startIndex][i] + lookup[i][endIndex] + p[startIndex] * p[i] * p[endIndex];

                if (val < min) {
                    min = val;
                }
            }
            lookup[startIndex][endIndex] = min;
        }

        return lookup[startIndex][endIndex];
    }

    public static void main(String[] args) {
        int p[] = { 10, 20, 30 };
        int[][] lookup = new int[3][3];

        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication();
        System.out.println("naive recursion solution : " + matrixChainMultiplication.mtrxMultiplyRecursive(p, 0, 2));

        System.out.println("dp solution : " + matrixChainMultiplication.mtxMultiplyDP(p, lookup, 0, 2));
    }

}