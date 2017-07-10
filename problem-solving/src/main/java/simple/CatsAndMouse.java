package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/cats-and-a-mouse
 */
public class CatsAndMouse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();


            int catA = Math.abs(z - x);
            int catB = Math.abs(z - y);
            String result = "Mouse C";
            if (catA < catB) result = "Cat A";
            if (catA > catB) result = "Cat B";
            System.out.println(result);

        }
    }
}
