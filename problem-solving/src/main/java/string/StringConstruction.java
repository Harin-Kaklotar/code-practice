package string;

import java.util.Scanner;

/**
 * Created by liju on 7/21/17.
 * https://www.hackerrank.com/challenges/string-construction
 */
public class StringConstruction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] tmp = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int count = 0 ;
            for (int j = 0; j < tmp.length; j++) {
                if (s.indexOf(tmp[j])!=-1) count++;
            }
            System.out.println(count);
        }
    }
}
