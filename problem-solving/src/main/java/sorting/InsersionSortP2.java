package sorting;

import java.util.Scanner;

/**
 * Created by liju on 8/11/17.
 *
 * https://www.hackerrank.com/challenges/insertionsort2
 */
public class InsersionSortP2 {
    public static void insertionSortPart2(int[] ar)
    {
       int i =1 ;
        while (i < ar.length) {
            int j = i;
            while (j > 0 && ar[j-1] > ar[j]) {
                int x = ar[j];
                ar[j] = ar[j - 1];
                ar[j - 1] = x;
                j--;
            }
            printArray(ar);
            i++;
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
