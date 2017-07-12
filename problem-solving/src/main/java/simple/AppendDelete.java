package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/11/17.
 * https://www.hackerrank.com/challenges/append-and-delete
 */
public class AppendDelete {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        char[] t = in.next().toCharArray();
        int k = in.nextInt();

        int i = 0;
        while (i < s.length && i < t.length && s[i] == t[i]) {
            i++;
        }

        int diff = s.length + t.length - 2 * i;

        System.out.println((diff <= k && diff % 2 == k % 2) || s.length + t.length < k ? "Yes" : "No");

    }
}
