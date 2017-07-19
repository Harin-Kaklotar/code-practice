package simple;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by liju on 7/16/17.
 * https://www.hackerrank.com/challenges/manasa-and-stones/problem
 */
public class MansaAndStones {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            if (a == b) {
                System.out.print((n - 1) * a);
            } else {
                if (a > b) { // swap to make "a" the smaller value.
                    int temp = a;
                    a = b;
                    b = temp;
                }
                for (int i = 0; i <= n - 1; i++) {
                    System.out.print(a * (n - 1 - i) + b * i + " ");
                }
            }
            System.out.println();
        }
    }
}
