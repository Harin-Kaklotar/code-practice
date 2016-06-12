package dp;

/**
 * Created by liju on 6/12/16.
 *
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order. For example, length of LIS for { 10, 22, 9,
 * 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 * Solution : Dynamic Programming is used to solve this question.
 * DP equation is if(arr[i] > arr[j]) { L[i] = max(L[i],L[j] + 1 }
 *
 * Time complexity is O(n^2). Space complexity is O(n)
 */
public class LongestIncreasingSubsequence {

    // solved using DP
    public int longestIncreasingSubSequence(int inputArray[]) {

        int L[] = new int[inputArray.length];
        for (int i = 0; i < L.length; i++) {
            L[i] = 1;
        }

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (inputArray[j] < inputArray[i]) {
                    L[i] = Math.max((1 + L[j]), L[i]);
                }
            }
        }
        // get the index containing max
        int maxIndex = 0;
        for (int i = 0; i < L.length; i++) {
            if (L[i] > L[maxIndex]) {
                maxIndex = i;
            }
        }

        // also print the solution
        // TODO

        // return lis
        return L[maxIndex];
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int A[] = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        System.out.println(lis.longestIncreasingSubSequence(A));
    }

    // TODO
    // solve the same using recursion
}
