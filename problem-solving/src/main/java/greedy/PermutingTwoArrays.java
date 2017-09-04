package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by liju on 9/2/17.
 * https://www.hackerrank.com/challenges/two-arrays
 */
public class PermutingTwoArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Long a[] = new Long[n];
            Long b[] = new Long[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextLong();
            }
            for (int j = 0; j < n; j++) {
                b[j] = sc.nextLong();
            }

            //solve
            Arrays.sort(a);
            Arrays.sort(b, Comparator.reverseOrder());
            boolean conditionMet = true;
            for (int j = 0; j < n; j++) {
                if (a[j] + b[j] < k) {
                    conditionMet = false;
                    break;
                }
            }
            System.out.println((conditionMet ? "YES" : "NO"));
        }
    }
}
