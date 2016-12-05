package array;

import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15,16}, target=9
 Output: index1=1, index2=2
 */
public class SortedArraySum {
    public static void main(String[] args) {
        SortedArraySum sortedArraySum = new SortedArraySum();
        System.out.println(Arrays.toString(sortedArraySum.twoSum(new int[]{0,0,1,4},0)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while (i<j){
            int sum = numbers[i]+numbers[j];
            if (target==sum) break;
            if (target > sum) i++;
            if (target < sum) j--;
        }

        return new int[]{i+1,j+1};
    }
}
