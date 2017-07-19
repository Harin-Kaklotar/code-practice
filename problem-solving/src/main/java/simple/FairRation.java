package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/16/17.
 * https://www.hackerrank.com/challenges/fair-rations/problem
 */
public class FairRation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        int odd = 0;
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            if (ar[i] % 2 != 0) odd++;
        }
        if (odd % 2 != 0) {
            System.out.println("NO");
            return;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (ar[i] % 2 != 0) {
                ar[i + 1] += 1;
                count += 2;
            }
        }

        System.out.println(count);
    }
}
