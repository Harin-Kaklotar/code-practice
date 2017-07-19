package string;

import java.util.Scanner;

/**
 * Created by liju on 7/18/17.
 *
 * https://www.hackerrank.com/challenges/caesar-cipher
 */
public class CaesarCipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] chars = sc.next().toCharArray();
        int k = sc.nextInt()%26;

        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 'A' && chars[i] <='Z') ){
                if (chars[i] + k >'Z')
                chars[i] = (char) (((chars[i] + k)%'Z')+'A' -1);
                else
                    chars[i] = (char) (chars[i] + k);
            }
            else if ((chars[i] >= 'a' && chars[i] <='z') ){
                if (chars[i] + k >'z')
                    chars[i] = (char) (((chars[i] + k)%'z')+'a' -1);
                else
                    chars[i] = (char) (chars[i] + k);
            }
        }

        System.out.println(String.copyValueOf(chars));
    }
}
