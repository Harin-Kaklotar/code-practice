package sorting;

import java.util.Scanner;

/**
 * Created by liju on 8/12/17.
 * <p>
 * https://www.hackerrank.com/challenges/countingsort2
 */
public class CountingSort2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[sc.nextInt()]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < ar[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
