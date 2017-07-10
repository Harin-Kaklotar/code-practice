package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/bon-appetit
 */
public class BonAppetit {

    static int bonAppetit(int n, int k, int b, int[] ar) {
        // Complete this function
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            if(i!=k) sum += ar[i];
        }
       return b - sum/2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        int result = bonAppetit(n, k, b, ar);
        if (result==0){
            System.out.println("Bon Appetit");
        }else{
            System.out.println(result);
        }

    }
}
