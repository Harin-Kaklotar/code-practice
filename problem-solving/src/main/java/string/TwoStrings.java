package string;

import java.util.Scanner;

/**
 * Created by liju on 7/21/17.
 * https://www.hackerrank.com/challenges/two-strings
 */
public class TwoStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] tmp = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            String result = "NO";

            for (int j = 0; j < tmp.length; j++) {
                if (a.indexOf(tmp[j])!=-1 && b.indexOf(tmp[j])!=-1){
                    result = "YES";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
