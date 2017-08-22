package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liju on 8/22/17.
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
 */
public class MinAbsDiff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int ar[] = new int [n];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }


        // logic

        Arrays.sort(ar);
        int minAbs = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            final int absVal = Math.abs(ar[i] - ar[i - 1]);
            if(absVal < minAbs) minAbs = absVal;
        }

        System.out.println(minAbs);

    }


}
