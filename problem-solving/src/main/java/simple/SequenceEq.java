package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/11/17.
 * https://www.hackerrank.com/challenges/permutation-equation
 */
public class SequenceEq {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = -1;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(findIndexOf(findIndexOf(i, arr), arr));
        }
    }

    private static int findIndexOf(int i, int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i) return j;
        }
        throw new IllegalArgumentException("element not found in the given array");
    }
}
