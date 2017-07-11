package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/10/17.
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies
 */
public class BeautifulDays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();

        int countBeautifulDays = 0;

        for (int l = i; l <= j ; l++) {
            if (Math.abs(l - reverse(l))%k == 0) countBeautifulDays++;
        }
        System.out.println(countBeautifulDays);

    }

    static int reverse(int input){
        long reversedNum = 0;

        long input_long = input;

        while (input_long != 0)
        {
            reversedNum = reversedNum * 10 + input_long % 10;
            input_long = input_long / 10;
        }

        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
        {
            throw new IllegalArgumentException();
        }
        return (int)reversedNum;
    }
}
