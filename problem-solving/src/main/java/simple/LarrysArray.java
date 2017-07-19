package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/18/17.
 *
 * https://www.hackerrank.com/challenges/larrys-array
 *
 * maths  - tricky  ( parity of permutation concept)
 */
public class LarrysArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int ar[] = new int[n];
            for (int j = 0; j < n; j++) {
                ar[j] = sc.nextInt();
            }
            System.out.println(calNumOfInversions(ar) % 2 == 0 ? "YES" : "NO");
        }
    }

    // formula for solvability
    // if number of inversion is even = YES else no

    private static int calNumOfInversions(int[] ar) {

        int inversions = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[j] < ar[i])
                    inversions++;
            }
        }
        return inversions;
    }

}
