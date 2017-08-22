package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by liju on 8/22/17.
 * https://www.hackerrank.com/challenges/marcs-cakewalk
 */
public class MarcsCakeWalk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final Integer ar[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        Arrays.sort(ar, Collections.reverseOrder());

        long totalMiles = 0;

        for (int i = 0; i < n; i++) {
            totalMiles += (ar[i] * Math.pow(2, i));
        }

        System.out.println(totalMiles);

    }
}
