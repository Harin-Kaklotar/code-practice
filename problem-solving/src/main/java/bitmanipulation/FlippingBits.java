package bitmanipulation;

import java.util.Scanner;

/**
 * Created by liju on 9/4/17.
 * https://www.hackerrank.com/challenges/flipping-bits
 */
public class FlippingBits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(solve(sc.nextLong()));
        }
    }

    //* hint : If maxInt is the maximum value an integer can have, subtracting the original number will give you the complement.
    // For example: If the input number is 6, that's 110 (00000110) in binary. 11111111 - 00000110 = 11111001, which, as you can see,
    // is the input value's flipped bits.


    static long solve(long num) {
        long intMax = (long) Math.pow(2, 32) - 1;
        return intMax - num;
    }
}
