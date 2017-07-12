package simple;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by liju on 7/11/17.
 * https://www.hackerrank.com/challenges/extra-long-factorials
 */
public class Factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(factorial(BigInteger.valueOf(num)));
    }

    static BigInteger factorial(BigInteger num) {
        if (num.intValue() == 1) return BigInteger.ONE;
        return num.multiply(factorial(num.subtract(BigInteger.ONE)));
    }
}
