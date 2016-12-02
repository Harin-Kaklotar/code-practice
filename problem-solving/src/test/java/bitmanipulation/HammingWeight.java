package bitmanipulation;

/**
 * Created by liju on 12/2/16. Write a function that takes an unsigned integer and returns the number of ’1' bits it has
 * (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function
 * should return 3.
 * 
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class HammingWeight {

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // use mask 1 to get the last bit and then right shift the number by 1 position
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
