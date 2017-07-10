package simple;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/sock-merchant
 */
public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        // Complete this function
        Set set  = new HashSet<Integer>();
        int total = 0;
        for (int i = 0; i < ar.length; i++) {
            if(!set.contains(ar[i])){
                set.add(ar[i]);
            }else {
                set.remove(ar[i]);
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
