package string;

import java.util.Scanner;

/**
 * Created by liju on 7/18/17.
 * https://www.hackerrank.com/challenges/reduced-string
 */
public class SuperReducedStr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                str = str.substring(0, i - 1) + str.substring(i + 1);
                i = 0;
            }
        }
        if (str.length() == 0) {
            System.out.println("Empty String");
        } else {
            System.out.println(str);
        }
    }
}
