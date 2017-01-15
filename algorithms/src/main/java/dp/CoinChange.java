package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liju on 6/13/16.
 * <p>
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * So the output should be 5.
 * <p>
 * ref - http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * <p>
 * https://www.hackerrank.com/challenges/coin-change
 *

 */
public class CoinChange {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int requiredSum = sc.nextInt();
        int noOfCoins = sc.nextInt();
        int[] coins = new int[noOfCoins];

        for (int i = 0; i < noOfCoins; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        long noOfWays = solve(coins, requiredSum);

        System.out.println(noOfWays);
    }

    /**
     1) Optimal Substructure
        To count total number solutions, we can divide all set solutions in two sets.
        1) Solutions that do not contain mth coin (or Sm).
        2) Solutions that contain at least one Sm.
         Let count(S[], m, n) be the function to count the number of solutions, then it can be written as sum of count(S[], m-1, n) and count(S[], m, n-Sm).

     Therefore, the problem has optimal substructure property as the problem can be solved using solutions to subproblems.

     2) Overlapping Subproblems
        Following is a simple recursive implementation of the Coin Change problem. The implementation simply follows the recursive structure mentioned above.
     * @param coins
     * @param requiredSum
     * @return
     */
    private static long solve(int[] coins, int requiredSum) {

        //required sum, +1 as starts from 0
        long[][] dp = new long[coins.length][requiredSum + 1];


        //intialize the first row
        for (int i = 0; i <= requiredSum; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;

        }
        for (int i = 1; i < coins.length; i++) {

            for (int j = 0; j <= requiredSum; j++) {
                if (j >= coins[i]) {
                    //Solutions that do not contain mth coin (or Sm) + Solutions that contain at least one Sm.
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length - 1][requiredSum];
    }
}
