package dp;

/**
 * Created by liju on 6/13/16.
 *
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 * Each cell of the matrix represents a cost to traverse through that cell.
 * Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
 * You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
 * You may assume that all costs are positive integers.
  (1,2,3)
  (4,8,2)
  (1,5,3)

 The path with minimum cost is highlighted in the following figure.
 The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).

 Ref - http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/

 */
public class MinCostPath {

    public int minCostRecursive(int[][] inArr, int m, int n) {

        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if (m == 0 && n == 0)
            return inArr[m][n];

        return (inArr[m][n] + min(minCostRecursive(inArr, m - 1, n), minCostRecursive(inArr, m, n - 1), minCostRecursive(inArr, m - 1, n - 1)));
    }

    public int minCostDP(int[][] inArr, int m, int n) {
        int minCost[][] = new int[m + 1][n + 1];
        //cost of (0,0) will remain same
        minCost[0][0] = inArr[0][0];
        //since we cant move backward or upward , initialize 0th row elements and 0th column elements
        for (int i = 1; i <= m; i++) {
            minCost[0][i] = inArr[0][i] + minCost[0][i - 1];
        }
        for (int i = 1; i <= n; i++) {
            minCost[i][0] = inArr[i][0] + minCost[i - 1][0];
        }

        //calculate remaining costs
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                minCost[i][j] = inArr[i][j] + min(minCost[i - 1][j - 1], minCost[i - 1][j], minCost[i][j - 1]);
            }

        }

        return minCost[m][n];

    }

    private int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        MinCostPath minCostPath = new MinCostPath();
        int[][] input = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
        System.out.println("Using recursion  - " + minCostPath.minCostRecursive(input, 2, 2));
        System.out.println("Using dp - " + minCostPath.minCostDP(input, 2, 2));
    }
}
