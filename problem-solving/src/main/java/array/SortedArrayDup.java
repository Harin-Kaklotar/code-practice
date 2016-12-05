package array;

/**
 * Created by Liju on 12/3/2016.
 *
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 https://leetcode.com/problems/remove-duplicates-from-sorted-array/

 eg.
 111123444
 121113444
 123111444
 123411144

 */
public class SortedArrayDup {

    public int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }

        }
        return i+1;
    }
}
