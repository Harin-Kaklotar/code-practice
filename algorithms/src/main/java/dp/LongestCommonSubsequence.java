package dp;

/**
 * Created by liju on 6/12/16.
 *
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 *
 * It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * //check LongestCommonSubsequence.md file
 *
 * Ref - http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 *
 */
public class LongestCommonSubsequence {

    // solved using dp
    public int lcs(char inputArr1[], char inputArr2[]) {

        int[][] solutionMatrix = new int[inputArr1.length + 1][inputArr2.length + 1];

        int max = 0;
        for (int i = 1; i <= inputArr1.length; i++) {
            for (int j = 1; j <= inputArr2.length; j++) {
                if (inputArr1[i - 1] == inputArr2[j - 1]) {
                    solutionMatrix[i][j] = solutionMatrix[i - 1][j - 1] + 1;
                } else {
                    solutionMatrix[i][j] = Math.max(solutionMatrix[i - 1][j], solutionMatrix[i][j - 1]);
                }

                if (max < solutionMatrix[i][j]) {
                    max = solutionMatrix[i][j];
                }
            }
        }

        return max;
    }

    // solved using recursion

    public int lcsRecursive(char[] input1, char[] input2, int pos1, int pos2) {

        if (input1.length == pos1 || input2.length == pos2) {
            return 0;
        }

        if (input1[pos1] == input2[pos2]) {
            return 1 + lcsRecursive(input1, input2, pos1 + 1, pos2 + 1);
        } else {
            return Math.max(lcsRecursive(input1, input2, pos1 + 1, pos2), lcsRecursive(input1, input2, pos1, pos2 + 1));
        }
    }

    public static void main(String[] args) {
        char[] input1 = new char[] { 'a', 'b', 'c', 'd', 'a', 'f' };
        char[] input2 = new char[] { 'a', 'c', 'b', 'c', 'f' };
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.lcs(input1, input2));
        System.out.println(lcs.lcsRecursive(input1, input2, 0, 0));

        char[] input3 = new char[] { 'A', 'B', 'C', 'D', 'G', 'H' };
        char[] input4 = new char[] { 'A', 'E', 'D', 'F', 'H', 'R' };

        System.out.println(lcs.lcs(input3, input4));
        System.out.println(lcs.lcsRecursive(input3, input4, 0, 0));

    }
}
