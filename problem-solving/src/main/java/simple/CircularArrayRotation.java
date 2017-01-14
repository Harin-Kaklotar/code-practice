package simple;

import java.util.Scanner;

/**
 * Created by liju on 1/13/17.
 * <p>
 * https://www.hackerrank.com/challenges/circular-array-rotation
 */
public class CircularArrayRotation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        int start;

        if (k > n) {
            k = k % n;
        }
        if (k == 1) {
            start = n - 1;
        } else {
            if (n > k)
                start = n - k;
            else
                start = n % k;
        }

        for (int i = 0; i < q; i++) {
            int index = sc.nextInt();
            System.out.println(x[(start + index) % n]);
        }
    }
}
