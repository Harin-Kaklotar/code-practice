package simple;

import java.util.Scanner;

/**
 * Created by liju on 1/14/17.
 *
 https://www.hackerrank.com/challenges/mini-max-sum

 */
public class MinMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long total=0;
        for (int i = 0; i < 5; i++) {
            int in = sc.nextInt();
            if (in>max)
                max=in;
            if (in<min)
                min=in;
            total += in;
        }
        System.out.println((total-max)+" "+(total-min));

    }
}
