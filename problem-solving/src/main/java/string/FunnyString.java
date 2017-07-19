package string;

import java.util.Scanner;

/**
 * Created by liju on 7/19/17.
 * https://www.hackerrank.com/challenges/funny-string
 */
public class FunnyString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            char[] chars = sc.next().toCharArray();


            String result = "Funny";
            for (int j = 1, k = chars.length - 1; j < chars.length && k >= 0; j++, k--) {

                if (Math.abs(chars[j] - chars[j - 1]) != Math.abs(chars[k] - chars[k - 1])) {
                    result = "Not Funny";
                    break;
                }
            }

            System.out.println(result);

        }
    }
}
