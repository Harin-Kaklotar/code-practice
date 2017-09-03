package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liju on 9/2/17.
 * https://www.hackerrank.com/challenges/angry-children/problem
 */
public class MinMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long a[] = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        Arrays.sort(a);
        long minmax = Long.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {
            long x = a[i + k - 1] - a[i];
            if (x < minmax)
                minmax = x;
        }

        System.out.println(minmax);
    }
}
