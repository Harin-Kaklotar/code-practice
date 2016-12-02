package bitmanipulation;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192
 * (represented in binary as 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 *
 * https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBit {

    public static void main(String[] args) {
            int i  = 43261596;
            System.out.println(reverseBits(i));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (n & 1); // n&1 returns last bit of n
            n >>>= 1;  // do unsigned right shift
            if (i < 31)
                result <<= 1; // do left shift
        }
        return result;
    }
}
