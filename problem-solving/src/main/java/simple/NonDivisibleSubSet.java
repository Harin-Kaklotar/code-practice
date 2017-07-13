package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/12/17.
 * https://www.hackerrank.com/challenges/non-divisible-subset
 *
 *  -- tricky
 */
public class NonDivisibleSubSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] remCount = new int[k];

        for (int i = 0; i < n; i++) {
            remCount[sc.nextInt() % k]++;
        }

        int totalCount = 0;

        for (int i = 0; i <= k / 2; i++) {
            if (i == 0 || i == (k - i))
                totalCount += Math.min(remCount[i], 1);
            else
                totalCount += Math.max(remCount[i], remCount[k - i]);
        }

        System.out.println(totalCount);
    }
}
