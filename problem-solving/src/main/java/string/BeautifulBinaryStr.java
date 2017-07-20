package string;

import java.util.Scanner;

/**
 * Created by liju on 7/19/17.
 *
 * https://www.hackerrank.com/challenges/beautiful-binary-string
 *
 */
public class BeautifulBinaryStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println((str.length() - str.replace("010", "").length()) / 3);
    }
}
