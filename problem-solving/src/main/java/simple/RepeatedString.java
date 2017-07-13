package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/12/17.
 * https://www.hackerrank.com/challenges/repeated-string
 *
 */
public class RepeatedString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.next().toCharArray();
        long n = sc.nextLong();


        long div  = n/chars.length;
        long rem = n % chars.length;

        long count_a =0;
        long rem_a = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='a') count_a++;

            if (i==(rem-1)) rem_a = count_a;
        }

        System.out.println(div*count_a + rem_a);

    }
}
