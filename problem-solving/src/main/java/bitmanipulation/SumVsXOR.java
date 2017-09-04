package bitmanipulation;

import java.util.Scanner;

/**
 * Created by liju on 9/4/17.
 * https://www.hackerrank.com/challenges/sum-vs-xor
 */
public class SumVsXOR {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println((long) (Math.pow(2, unsetBits(n))));
    }

    static long unsetBits(long n) {
        long count = 0;
        while (n > 0) {
            count += (n % 2 == 0) ? 1 : 0;
            n = n / 2;
        }
        return count;
    }
}
