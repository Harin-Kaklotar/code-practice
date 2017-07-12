package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/11/17.
 * <p>
 * https://www.hackerrank.com/challenges/library-fine
 */
public class LibraryFine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rd = sc.nextInt();
        int rm = sc.nextInt();
        int ry = sc.nextInt();

        int ad = sc.nextInt();
        int am = sc.nextInt();
        int ay = sc.nextInt();

        System.out.println(solve(rd, rm, ry, ad, am, ay));

    }

    private static int solve(int rd, int rm, int ry, int ad, int am, int ay) {

        if (ry - ay > 0) return 10000;
        else {
            if (ry == ay && rm - am > 0 ) return (rm - am) * 500;
            else {
                if (ry == ay  && rm == am && rd - ad > 0) return (rd - ad) * 15;
                else return 0;
            }
        }
    }
}
