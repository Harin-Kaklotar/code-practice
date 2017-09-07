package bitmanipulation;

import java.util.Scanner;

/**
 * Created by liju on 9/4/17.
 */
public class AndProduct {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long a = in.nextLong();
            long b = in.nextLong();
            long res = a & (a + 1);
            int i = 1;
            while (a + (long) Math.pow(2, i) <= b) {
                res = (a + (long) Math.pow(2, i)) & res;
                ++i;
            }
            System.out.println(res & b);
        }
    }
}
