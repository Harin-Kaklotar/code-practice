package string;

import java.util.Scanner;

/**
 * Created by liju on 8/6/17.
 * Longest common increasing substring
 * https://www.hackerrank.com/challenges/common-child
 * <p>
 * hint  - DP
 */
public class LCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s1 = sc.next().toCharArray();
        char[] s2 = sc.next().toCharArray();

        System.out.println(lcs(s1, s2));
    }

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    private static long lcs(char[] s1, char[] s2) {

        int m = s1.length;
        int n = s2.length;
        int len[][] = new int[m + 1][n + 1];

        /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    len[i][j] = 0;
                else if (s1[i - 1] == s2[j - 1])
                    len[i][j] = 1 + len[i - 1][j - 1];
                else
                    len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
            }
        }

        return len[m][n];
    }
}
