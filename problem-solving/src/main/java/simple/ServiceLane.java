package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/15/17.
 * https://www.hackerrank.com/challenges/service-lane
 */
public class ServiceLane {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] lane = new int[n];
        for (int i = 0; i < n; i++) {
            lane[i] = sc.nextInt();
        }

        for (int i = 0; i < t; i++) {
            System.out.println(solve(sc.nextInt(), sc.nextInt(), lane));
        }
    }

    private static int solve(int i, int j, int[] lane) {
        int min = 3;

        for (int k = i; k <= j; k++) {
            if (lane[k] < min) min = lane[k];
        }

        return min;
    }
}
