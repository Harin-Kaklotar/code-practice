package bitmanipulation;

import java.util.Scanner;

/**
 * Created by liju on 9/4/17.
 * https://www.hackerrank.com/challenges/the-great-xor/problem
 */
public class GreatXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
    }


   static long theGreatXor(long x){
        // Complete this function
        long result = 0;
        int bitPos = 0;
        while(x>0) {
            if((x&1) == 0) {
                result += (1L<<bitPos);
            }
            bitPos++;
            x >>= 1;
        }
        return result;
    }
}
