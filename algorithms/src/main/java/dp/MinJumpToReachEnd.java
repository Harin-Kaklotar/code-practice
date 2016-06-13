package dp;

/**
 * Created by liju on 6/12/16.
 *
 * Given an array of non negative integers where each element represents the max number of steps that can be made
 * forward from that element. Write a function to return the minimum number of jumps to reach the end of the array from
 * first element
 *
 * Example: Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} Output: 3 (1-> 3 -> 8 ->9)
 *
 * Solution Have 2 for loop. j trails i. If arr[j] + j >= i then you calculate new jump and result.
 *
 * Space complexity O(n) to maintain result and min jumps Time complexity O(n^2)
 *
 * Reference http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 *
 */
public class MinJumpToReachEnd {

    public int minJumps(int[] input, int[] result) {
        // minJump is the array containg min jumps required to reach the ith index
        // initializing it to integer max
        int[] minJump = new int[input.length];

        minJump[0] = 0; // min jump to reach 0th index is always 0
        for (int i = 1; i < minJump.length; i++) {
            minJump[i] = Integer.MAX_VALUE - 1; // -1 for +ve max
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                // check if we can jump from j to i , (i-j) is the min steps required
                if (input[j] >= (i - j)) {
                    // if current min jump to i is greater than new computed jump from j then update
                    // jump from j would required minJump[j]+1
                    if (minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                        result[i] = j;
                    }

                }
            }
        }

        return minJump[minJump.length - 1];
    }

    public static void main(String[] args) {
        MinJumpToReachEnd jumpToReachEnd = new MinJumpToReachEnd();
        int arr1[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        int arr2[] = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };

        int[] result1 = new int[arr1.length];
        int[] result2 = new int[arr2.length];

        System.out.println("Min jump required for arr1: " + jumpToReachEnd.minJumps(arr1, result1));
        System.out.println("result for arr1: " + result1);
        System.out.println("Min jump required for arr2: " + jumpToReachEnd.minJumps(arr2, result2));

        int index = result2.length - 1;
        do {
            System.out.print(result2[index] + "\t");
            index = result2[index];
        } while (index != 0);
    }
}
