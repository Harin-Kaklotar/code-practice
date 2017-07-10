package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/drawing-book
 */
public class DrawingBook {

    static int solve(int n, int p) {
        // Complete this function
        return Math.min(pagesFromFront(n, p), pagesFromBack(n, p));
    }

    private static int pagesFromBack(int n, int p) {

        if (n % 2 == 0) {
            if (p % 2 == 0) return (n - p) / 2;
            else return (n - p + 1) / 2;
        } else {
            return (n - p) / 2;
        }
    }

    private static int pagesFromFront(int n, int p) {
        return p / 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
