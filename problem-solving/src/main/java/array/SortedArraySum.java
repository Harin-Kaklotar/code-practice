package array;
/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15,16}, target=9
 Output: index1=1, index2=2
 */
public class SortedArraySum {




     class Solution {
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i+1; j < numbers.length; j++) {
                    int sum = numbers[i]+numbers[j];
                    if (sum==target){
                        return new int[]{i+1,j+1};
                    }
                }
            }
            return null;
        }
    }
}