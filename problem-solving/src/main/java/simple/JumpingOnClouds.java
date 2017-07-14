package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/12/17.
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */
public class JumpingOnClouds {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }

        System.out.println(solve(c,0,0));

    }

    private static int solve(int[] c, int curPos,int steps) {

        if (curPos==c.length-1) return steps;

        if (curPos+2 <= c.length && c[curPos+2]!=1) {
            solve(c, curPos + 2, steps++) ;return steps;
        };
        if (curPos+1 <= c.length && c[curPos+1]!=1){
            solve(c,curPos+1,steps++);
            return steps;
        }
        return -1;
    }

}
