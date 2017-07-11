package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/10/17.
 * https://www.hackerrank.com/challenges/the-hurdle-race
 */
public class HurdleRace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int max = Integer.MIN_VALUE;
        for(int height_i=0; height_i < n; height_i++){
            int x = in.nextInt();
            if (x > max) max =x;
        }

        int diff = max-k;
        System.out.println(diff <=0 ? 0 : diff);
        // your code goes here
    }

}
