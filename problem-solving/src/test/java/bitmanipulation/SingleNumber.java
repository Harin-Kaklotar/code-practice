package bitmanipulation;

/**
 * Created by liju on 12/1/16. Given an array of integers, every element appears twice except for one. Find that single
 * one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * https://leetcode.com/problems/single-number/
 */

public class SingleNumber {

    public static void main(String[] args) {
        int[] input = new int[] { 1, 1, 5, 5, 9, 6, 6 };
        final int result = Solution.singleNumber(input);
        System.out.println(result);
    }

    static class Solution {
        public static int singleNumber(int[] nums) {
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                result = result ^ nums[i];
            }
            return result;
        }
    }
}
