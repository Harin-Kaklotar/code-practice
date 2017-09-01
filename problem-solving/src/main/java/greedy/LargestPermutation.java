package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liju on 9/1/17.
 * https://www.hackerrank.com/challenges/largest-permutation
 * <p>
 * index arrays
 */
public class LargestPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ar = new int[n];
        int[] index = new int[n + 1];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            index[ar[i]] = i;
        }

        for (int i = 0; i < n && k > 0; i++) {
            if (ar[i] != (n - i)) {
                ar[index[n - i]] = ar[i];
                index[ar[i]] = index[n - i];
                ar[i] = n - i;
                index[n - i] = i;
                k--;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ar[i] + " ");
        }
    }
}
