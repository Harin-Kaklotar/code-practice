package simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liju on 7/11/17.
 * https://www.hackerrank.com/challenges/sherlock-and-squares
 *
 * -- identify the catch
 */
public class CountSquares {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a =sc.nextInt();
            int b =sc.nextInt();
            Double diff = Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a))+1;
            System.out.println(diff.intValue());
        }
    }
}
