package simple;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/picking-numbers
 */
public class PickingNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        System.out.println(solve(a));
    }

    private static int solve(int[] a) {

        int[] tmp  = new int[100];
        for (int i = 0; i < a.length; i++) {
            tmp[a[i]]++;
        }

        int max = 0;
        for (int i = 0; i+1 < tmp.length; i++) {
            int sum = tmp[i]+tmp[i+1];
            if (sum > max) max=sum;
        }
        return max;
    }

}
