package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/10/17.
 * https://www.hackerrank.com/challenges/strange-advertising
 */
public class ViralAdvertising {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(0, n, 5, 0));
    }

    static int solve(int i, int n, int val, int acc) {
        i++;
        int x = val - (val - ((Double) (Math.ceil(val / 2))).intValue());
        acc += x;
        if (i == n) return acc;
        return solve(i, n, x * 3, acc);
    }
}
