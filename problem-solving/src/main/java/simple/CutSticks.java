package simple;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liju on 7/12/17.
 *
 * https://www.hackerrank.com/challenges/cut-the-sticks
 */
public class CutSticks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();

        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        Arrays.sort(ar);

        int same  = 1;
        int left = n;

        System.out.println(left);
        int start = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (ar[i]==start) same++;
            else {
                left = left - same;
                System.out.println(left);
                start = ar[i];
                same=1;
            }
        }
    }
}
