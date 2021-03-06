package bitmanipulation;

import java.util.Scanner;

/**
 * Created by liju on 9/4/17.
 *
 * https://www.hackerrank.com/challenges/maximizing-xor
 */
public class MaximizingXOR {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int L = scan.nextInt();
        int R = scan.nextInt();
        scan.close();

        int xored  = L ^ R;
        int significantBit = 31 - Integer.numberOfLeadingZeros(xored);
        int result = (1 << (significantBit + 1)) - 1;

        System.out.println(result);
    }
}
