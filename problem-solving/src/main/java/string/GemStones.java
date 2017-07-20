package string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liju on 7/19/17.
 *
 * https://www.hackerrank.com/challenges/gem-stones
 */
public class GemStones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Character> comp = new HashSet<>();

        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char[] chars = sc.next().toCharArray();

            for (int j = 0; j < chars.length; j++) {
                if (i == 0) {
                    comp.add(Character.valueOf(chars[j]));
                } else {
                    set2.add(Character.valueOf(chars[j]));
                }
            }
            if (i != 0) {
                comp.retainAll(set2);
                set2.clear();
            }
        }

        System.out.println(comp.size());

    }
}
