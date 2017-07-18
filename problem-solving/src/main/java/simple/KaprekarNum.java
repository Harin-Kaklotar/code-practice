package simple;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by liju on 7/15/17.
 * https://www.hackerrank.com/challenges/kaprekar-numbers
 */
public class KaprekarNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();


        boolean found = false;
        for (int i = p; i <= q; i++) {

            if (isKaprekar(i)) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found)
            System.out.println("INVALID RANGE");
    }

    private static boolean isKaprekar(int num) {

        BigInteger result = BigInteger.valueOf(num).multiply(BigInteger.valueOf(num));

        String val = result.toString();
        int mid = val.length() / 2;

        int p1 = 0, p2 = 0;
        if (val.substring(0, mid).length() > 0)
            p1 = Integer.valueOf(val.substring(0, mid));
        if (val.substring(mid, val.length()).length() > 0)
            p2 = Integer.valueOf(val.substring(mid, val.length()));

        if (p1 + p2 == num) return true;
        else return false;

    }
}
