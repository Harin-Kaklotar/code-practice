package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/migratory-birds
 */
public class MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        int a[] = new int[5];
        for(int i = 0;i < ar.length;i++){
            a[ar[i]-1]++;
        }

        int maxIndex = 0;
        for(int i =1 ;i < a.length;i++){
            if (a[i]>a[maxIndex]) maxIndex = i;
        }
        return maxIndex+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
