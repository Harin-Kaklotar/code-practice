package sorting;

import java.util.Scanner;

/**
 * Created by liju on 8/11/17.
 * https://www.hackerrank.com/challenges/countingsort1
 */
public class CountingSort1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count[] = new int[100];

        for (int i = 0; i < n; i++) {
            count[sc.nextInt()]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
    }
}
