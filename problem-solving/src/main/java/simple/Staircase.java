package simple;

import java.util.Scanner;

/**
 * Created by liju on 1/13/17.
 https://www.hackerrank.com/challenges/staircase
 */
public class Staircase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        char space = ' ';
        char hash = '#';
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = j; k < (n - i); k++) {
                    System.out.print(space);
                }
                for (int k = (n-i); k <n ; k++) {
                    System.out.print(hash);
                }
                System.out.print("\n");
                break;
            }

        }
    }
}
