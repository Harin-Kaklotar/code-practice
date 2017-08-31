package greedy;

import java.util.Scanner;

/**
 * Created by liju on 8/31/17.
 * https://www.hackerrank.com/challenges/priyanka-and-toys/problem
 */
public class PriyankaAndToys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[100001];

        for (int i = 0; i < n; i++) {
            ar[sc.nextInt()]++;
        }

        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > 0) {
                i += 4;
                count++;
            }
        }

        System.out.println(count);
    }
}
