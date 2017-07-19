package string;

import java.util.Scanner;

/**
 * Created by liju on 7/18/17.
 * https://www.hackerrank.com/challenges/camelcase
 */
public class CamelCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.next().toCharArray();
        int count = 0 ;
        if (chars.length>0) count++;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <='Z') count++;
        }
        System.out.println(count);

    }
}
