package string;

import java.util.Scanner;

/**
 * Created by liju on 7/18/17.
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string
 */
public class HackerrankInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(checkIfIsHacker(sc.next()));
        }
    }

    private static String checkIfIsHacker(String s) {

        String str = "hackerrank";
        if (s.length() < str.length()) {
            return "NO";
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < str.length() && s.charAt(i) == str.charAt(j)) {
                j++;
            }
        }
        return (j == str.length() ? "YES" : "NO");

    }
}
