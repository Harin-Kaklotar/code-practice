package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/10/17.
 * https://www.hackerrank.com/challenges/utopian-tree
 */
public class UtopianTree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(solve(sc.nextInt()));
        }
    }

    static int solve(int i) {
        if (i == 0) return 1;
        if (i % 2 == 0) return solve(i - 1) + 1;
        else {
            return solve(i - 1) * 2;
        }
    }
}
