package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/14/17.
 * https://www.hackerrank.com/challenges/bigger-is-greater
 */
public class BiggerGreater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            nextLexographicalPermutation(input.toCharArray());
        }
    }
    static void nextLexographicalPermutation(char[] input){

         // 0 1 2 5 3 3 0

        // Find longest non-increasing suffix
        int i  = input.length -1;
        while (i>0 && input[i] <= input[i-1]) i--;

        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i<=0) {
            System.out.println("no answer"); return;
        }

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot

        int j =input.length-1;
        while (j>=i && input[j]<=input[i-1])j--;

        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j

        char tmp = input[i-1];
        input[i-1] = input[j];
        input[j] = tmp;

        // reverse the suffix

        j = input.length -1;
        while (j>i){
            char temp  = input[j];
            input[j]=input[i];
            input[i] = temp;
            i++;
            j--;

        }

        System.out.println(String.valueOf(input));

    }
}
