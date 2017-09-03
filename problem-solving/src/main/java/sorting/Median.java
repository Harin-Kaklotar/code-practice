package sorting;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liju on 8/12/17.
 * https://www.hackerrank.com/challenges/find-the-median
 */
public class Median {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        Arrays.sort(ar);

        NumberFormat nf = new DecimalFormat("##.###");
        if (n%2!=0)
            System.out.println(ar[n/2]);
        else {
            double d = ((double) (ar[n / 2 - 1] + ar[n / 2]) / 2);
            System.out.println(nf.format(d));
        }
    }
}
