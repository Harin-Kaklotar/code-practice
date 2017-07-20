package string;

import java.util.Scanner;

/**
 * Created by liju on 7/19/17.
 *
 * https://www.hackerrank.com/challenges/alternating-characters
 */
public class AlternatingCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            String test = sc.next();
            int count = 0;
            for (int j = 0; j < test.length() - 1; j++) {
                if (test.charAt(j) == test.charAt(j + 1))
                    count++;
            }
            System.out.println(count);
        }
    }
}
