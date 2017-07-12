package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/11/17.
 * https://www.hackerrank.com/challenges/find-digits
 */
public class FindDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(solve(sc.nextInt()));
        }
    }

    static int solve(int num) {
        int i = num;
        int count = 0;
        while (i > 0) {
            int lastDigit = i % 10;
            if (lastDigit != 0 && num % lastDigit == 0) count++;
            i = i / 10;
        }
        return count;
    }
}
