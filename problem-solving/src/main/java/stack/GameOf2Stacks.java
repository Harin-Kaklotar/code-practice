package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by liju on 7/8/17.
 * <p>
 * https://www.hackerrank.com/challenges/game-of-two-stacks
 */
public class GameOf2Stacks {


    public static void main(String[] args) {

        //get the inputs

        Scanner sc = new Scanner(System.in);

        int noOfGames = sc.nextInt();

        while (noOfGames > 0) {
            int noOfElemInStackA = sc.nextInt();
            int noOfElemInStackB = sc.nextInt();
            int n = sc.nextInt();

            int a[] = new int[noOfElemInStackA];
            int b[] = new int[noOfElemInStackB];

            readInput(sc, a);
            readInput(sc, b);

            int ans = solve(a, b, n);

            System.out.println(ans);
            noOfGames--;
        }

        sc.close();

    }

    private static int solve(int[] a, int[] b, int n) {
        int sum = 0;
        int maxIndexA = -1; // if there is no solution
        int max;
        for (int i = 0; i < a.length && sum + a[i] <= n; i++) {
            sum += a[i];
            maxIndexA = i;
        }

        max = maxIndexA + 1;

        // either sum is till less than n and array a items exhausted or items are still there but sum is exceeds on next item

        for (int i = 0; i < b.length; i++) {
            sum += b[i];
            // either sum exceeds or is still not reached to n
            while (sum > n && maxIndexA >= 0) {
                sum -= a[maxIndexA];
                maxIndexA--;
            }

            if (sum > n) break;
            max = Math.max(max, (i + 1) + (maxIndexA + 1));
        }

        return max;
    }

    private static void readInput(Scanner sc, int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
    }

}
