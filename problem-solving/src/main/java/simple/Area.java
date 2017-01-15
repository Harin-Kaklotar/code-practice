package simple;

import java.util.Scanner;

/**
 * Created by liju on 1/14/17.
 https://www.hackerrank.com/challenges/designer-pdf-viewer
 */
public class Area {

    public static void main(String[] args) {
        int[] hgt = new int[26];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 26; i++) {
            hgt[i] = sc.nextInt();
        }
        char[] chars = sc.next().toCharArray();
        int maxhgt = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            if (hgt[chars[i]-'a']>maxhgt)
                maxhgt=hgt[chars[i]-'a'];
        }
        System.out.println(maxhgt*chars.length);
    }
}
