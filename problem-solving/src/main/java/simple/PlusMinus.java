package simple;

import java.util.Scanner;

/**
 * Created by liju on 1/13/17.
 https://www.hackerrank.com/challenges/plus-minus
 */
public class PlusMinus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();

        double positive=0;
        double negative=0;
        double zero=0;
        double total=0;
        for (int i = 0; i < n; i++) {
            final int j = sc.nextInt();
            if(j<0)
                negative++;
            else if (j>0)
                positive++;
            else
                zero++;
            total++;
        }

        System.out.println(positive/total);
        System.out.println(negative/total);
        System.out.println(zero/total);
    }
}
