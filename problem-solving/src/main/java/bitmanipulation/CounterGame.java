package bitmanipulation;

import java.util.Scanner;

/**
 * Created by liju on 9/4/17.
 * https://www.hackerrank.com/challenges/counter-game
 */
public class CounterGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            System.out.println(((calculateSetBits(n - 1) & 1) > 0) ? "Louise" : "Richard");
        }
    }

    static long calculateSetBits(long n) {
        int count = 0;

        while (n > 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
