package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/15/17.
 * https://www.hackerrank.com/challenges/chocolate-feast
 */
public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(solve(n,c,m));
        }

    }

    private static int solve(int n, int c, int m) {
        int count = n/c;
        n = n/c;

        while (n>=m){
            count+=n/m;
            n=n/m + n%m;
        }

        return count;
    }
}
