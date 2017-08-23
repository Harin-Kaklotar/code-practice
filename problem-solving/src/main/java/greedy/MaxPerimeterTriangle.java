package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by liju on 8/22/17.
 * <p>
 * https://www.hackerrank.com/challenges/maximum-perimeter-triangle/problem
 * <p>
 * Select the longest possible side such that it can form a non-degenerate triangle using the two sides "just smaller" than it.
 * It fulfills all other conditions. If no such selection is possible, then no non-degenerate triangle exists.
 */
public class MaxPerimeterTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer ar[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        Arrays.sort(ar, Collections.reverseOrder());

        int index = -1;
        for (int i = 0; i < n - 2; i++) {
            if (ar[i] < ar[i + 1] + ar[i + 2]) {
                index = i;
                break;
            }
        }

        if (index != -1)
            System.out.println(ar[index + 2] + " " + ar[index + 1] + " " + ar[index]);
        else
            System.out.println(index);

    }
}
