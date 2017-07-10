package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 */
public class MagicSquare {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for (int s_i = 0; s_i < 3; s_i++) {
            for (int s_j = 0; s_j < 3; s_j++) {
                s[s_i][s_j] = in.nextInt();
            }
        }
        //  Print the minimum cost of converting 's' into a magic square

        System.out.println(solve(s));
    }

    private static int solve(int[][] s) {

        // each row/column sum  = 15 , total = 45 ( 1-9)  , 45 /3  = 15
        // middle element should be 5 ( found after calculation )
        //other two elements with middle as 5 is (1,9) ,(2,8),(3,7),(4,6)
        // if 4 goes Top/Left, we know that 6 must go Bottom/Right (since the "magic sum" must be 15, and 5 is in the middle)
        // only 2,4,6,8 can be on the corners , total 8 such matrices are possible


        int magic_mat[][][] = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
        };


        //compare the given matrix against each of the above one to get the min cost


        int minCost = Integer.MAX_VALUE; // max can be 9*

        for (int i = 0; i < 8; i++) {
            int cost = 0;
            for (int j = 0; j < s.length; j++) {
                for (int k = 0; k < s.length; k++) {
                    cost += Math.abs(s[j][k] - magic_mat[i][j][k]);
                }
            }
            if (cost < minCost) minCost = cost;
        }

        return minCost;
    }
}
