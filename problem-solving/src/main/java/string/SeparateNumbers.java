package string;

import java.util.Scanner;

/**
 * Created by liju on 7/19/17.
 * https://www.hackerrank.com/challenges/separate-the-numbers
 *
 *  Easy  - Tricky
 */
public class SeparateNumbers {


    /**
     * Case 1: s=1234
         In the first iteration of the for loop, we consider the first digit in the number.So we take 1. Now concat the number to string Test.
         Test=1.Then added 1 to it=>2. Then concatinate to Test.
         Test=12. Then added 1 again. Concatinate to Test
         Test=123. Then added 1 again. Concatinate to Test
         Test=1234. Now the length of test and s are equal. So we compare the two strings. If they are equal, we have the solution.

         Case 2: s=121314
         We do the steps as above. But after the first iteration in the for loop Test=123456. When we compare, the strings are not equal. So continuing to second iteration of for loop... Now we take the first TWO digits,ie,12. Then, as stated above, we add 1 and concatinate until length of s and Test are the same. So,
         Test=12
         Test=1213
         Test=121314. Now we compare the lengths. They are the same. So we compare the strings. They are equal. Hence the solution.
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            boolean valid = false;
            long firstx = -1;
            // Try each possible starting number
            for (int i=1; i<=s.length()/2; ++i) {
                long x = Long.parseLong(s.substring(0,i));
                firstx = x;
                // Build up sequence starting with this number
                String test = Long.toString(x);
                while (test.length() < s.length()) {
                    test += Long.toString(++x);
                }
                // Compare to original
                if (test.equals(s)) {
                    valid = true;
                    break;
                }
            }
            System.out.println(valid ? "YES " + firstx : "NO");
        }
    }
}
