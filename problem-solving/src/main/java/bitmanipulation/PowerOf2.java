package bitmanipulation;

/**
 * Created by liju on 12/2/16. Given an integer, write a function to determine if it is a power of two.
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(-8));
        System.out.println(isPowerOfTwo(7));
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(-2147483646));

        System.out.println(prefferedSolution(8));
        System.out.println(prefferedSolution(-8));
        System.out.println(prefferedSolution(7));
        System.out.println(prefferedSolution(0));
        System.out.println(prefferedSolution(-2147483646));

    }

    /**
     * The key idea here is to realize that for any number n, doing a bit-wise AND of n and n - 1 flips the
     * least-significant 1-bit in n to 0.
     */

    public static boolean prefferedSolution(int n) {
        if (n < 0)
            return false;
        return (n & (n - 1)) == 0 ? true : false;
    }

    // using bitwise shift
    public static boolean isPowerOfTwo(int n) {
        if (n < 0)
            return false;
        int count = 0;
        if (n == 0)
            return false;
        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            if (count == 2) {
                return false;
            }
            n >>>= 1;
        }
        return true;
    }
}
