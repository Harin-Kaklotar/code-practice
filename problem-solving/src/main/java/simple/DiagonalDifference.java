package simple;

import java.util.Scanner;

/**
 * Created by liju on 1/13/17.
 https://www.hackerrank.com/challenges/diagonal-difference
 */
public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int d1=0;
        int d2=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j){
                    d1 += matrix[i][j];
                }
                if (i+j==(n-1)){
                    d2 += matrix[i][j];
                }
            }
        }
        System.out.println(Math.abs(d1-d2));
    }
}
