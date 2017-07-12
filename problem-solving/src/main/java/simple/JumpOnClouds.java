package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/11/17.
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
 */
public class JumpOnClouds {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int curPos = 0;
        int E = 100;
        do {
            curPos = (curPos + k) % n;
            E--;
            if (arr[curPos] != 0) E = E - 2;

        } while (curPos != 0);

        System.out.println(E);

    }
}
