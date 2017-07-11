package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/10/17.
 * https://www.hackerrank.com/challenges/save-the-prisoner
 */
public class SavePrisoner {

    static int saveThePrisoner(int n, int m, int s) {
        // Complete this function
        int poisoned = (s + m - 1) % n;
        if (poisoned == 0)
            poisoned = n;
        return poisoned;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int result = saveThePrisoner(n, m, s);
            System.out.println(result);
        }
    }
}
