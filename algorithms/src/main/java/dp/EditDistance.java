package dp;

/**
 * Created by liju on 6/13/16.
 *
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
    - Insert
    - Remove
    - Replace

 Eg. Input:   str1 = "geek", str2 = "gesek"
 Output:  1
 We can convert str1 into str2 by inserting a 's'.

 Input:   str1 = "cat", str2 = "cut"
 Output:  1
 We can convert str1 into str2 by replacing 'a' with 'u'.

 Input:   str1 = "sunday", str2 = "saturday"
 Output:  3
 Last three and first characters are same.  We basically
 need to convert "un" to "atur".  This can be done using
 below three operations.
 Replace 'n' with 'r', insert t, insert a

 Ref - http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings. So we recur for lengths m-1 and n-1.
 Else (If last characters are not same), we consider all operations on ‘str1′, consider all three operations on last character of first string, recursively compute minimum cost for all three operations and take minimum of three values.
 Insert: Recur for m and n-1
 Remove: Recur for m-1 and n
 Replace: Recur for m-1 and n-1
 */
public class EditDistance {

    private static int min(int a, int b, int c) {
        if (a < b && a < c)
            return a;
        else if (b < a && b < c)
            return b;
        else
            return c;
    }

    /**
     *
     * @param str1
     *            - input string 1
     * @param str2
     *            - input string 2
     * @param m
     *            - input length of str1
     * @param n
     *            - input length of str2
     * @return
     */
    public int editDistanceRecursive(char[] str1, char[] str2, int m, int n) {
        // if first string is empty , insert all of str2
        if (m == 0)
            return n;

        // if str2 is empty ,remove all of str1
        if (n == 0)
            return m;

        if (str1[m - 1] == str2[n - 1]) {
            return editDistanceRecursive(str1, str2, m - 1, n - 1);
        }

        return 1 + min(editDistanceRecursive(str1, str2, m - 1, n), // remove
                editDistanceRecursive(str1, str2, m, n - 1),// insert
                editDistanceRecursive(str1, str2, m - 1, n - 1));// replace

    }

    public int editDistanceDP(char[] str1, char[] str2) {
        int[][] solMtx = new int[str1.length + 1][str2.length + 1];
        for (int i = 0; i <= str1.length; i++) {
            for (int j = 0; j <= str2.length; j++) {

                // 1st string is empty , then insert all the characters of str 2
                if (i == 0) {
                    solMtx[i][j] = j;
                }
                // 1st string is empty , then insert all the characters of str 1
                else if (j == 0) {
                    solMtx[i][j] = i;
                } else if (str1[i - 1] == str2[j - 1]) {
                    solMtx[i][j] = solMtx[i - 1][j - 1];
                } else {
                    solMtx[i][j] = 1 + min(solMtx[i][j - 1], solMtx[i - 1][j], solMtx[i - 1][j - 1]);
                }
            }

        }

        return solMtx[str1.length][str2.length];
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        EditDistance editDistance = new EditDistance();
        System.out.println("Using dp - " + editDistance.editDistanceDP(str1.toCharArray(), str2.toCharArray()));
        System.out.println("Using recursion - " + editDistance.editDistanceRecursive(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
    }
}
