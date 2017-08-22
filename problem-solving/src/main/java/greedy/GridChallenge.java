package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liju on 8/22/17.
 * https://www.hackerrank.com/challenges/grid-challenge
 */
public class GridChallenge {

    //TODO - correct the logic
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();
            int ar[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                final char[] row = sc.next().toCharArray();
                Arrays.sort(row);
                for (int k = 0; k < n; k++) {
                    ar[i][k] = row[k];
                }
            }
            System.out.println(checkCondition(ar));
        }
    }

    private static boolean checkCondition(int[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length && (i+1) < ar.length; j++) {
                if (ar[i][j] > ar[i+1][j]) return false;
            }
        }
        return true;
    }
}
