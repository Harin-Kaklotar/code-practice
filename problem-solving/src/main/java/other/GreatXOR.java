package other;

import java.util.Scanner;

/**
 * Created by liju on 1/10/17.
 * <p>
 * https://www.hackerrank.com/contests/w28/challenges/the-great-xor
 */
public class GreatXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            long num = in.nextLong();
            long powerOf2 = powerOf2(num);
            System.out.println(powerOf2 - 1 - (num - powerOf2));
        }
    }

    public static long powerOf2(long num) {
        if (num == 0) {
            return 1;
        }
        if (num > 0 && (num & (num - 1)) == 0) {
            return num;
        }
        while ((num & (num - 1)) > 0) {
            num = num & (num - 1);
        }
        return num;
    }
}
