package string;

import java.util.Scanner;

/**
 * Created by liju on 7/19/17.
 *
 * https://www.hackerrank.com/challenges/the-love-letter-mystery
 */
public class LoveLetterMystery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println(solve(sc.next().toCharArray()));
        }
    }

    private static int solve(char[] input) {
        int i =0;
        int j = input.length-1;

        int count=0;
        while (i<j){
            int max = Math.max(input[i],input[j]);
            int min = Math.min(input[i], input[j]);

            count += max - min;
            i++;j--;

        }
        return count;
    }
}
