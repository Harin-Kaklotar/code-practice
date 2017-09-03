package greedy;

import java.util.*;

/**
 * Created by liju on 9/1/17.
 * https://www.hackerrank.com/challenges/greedy-florist
 */
public class GreedyFlorist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer a[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a, Collections.reverseOrder());
        int minCost = 0;

        if (k >= n) {
            for (int i = 0; i < n; i++) {
                minCost += a[i];
            }
        } else {
            for (int i = 0, customer = 0, round = 0; i < n; i++, customer++) {
                if (customer == k) {
                    customer = 0;
                    round++;
                }
                minCost += (round + 1) * a[i];
            }
        }
        System.out.println(minCost);
    }
}
