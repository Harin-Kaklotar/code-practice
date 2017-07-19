package string;

import java.util.Scanner;

/**
 * Created by liju on 7/18/17.
 * https://www.hackerrank.com/challenges/mars-exploration
 */
public class MarsExploration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(countChanges(sc.next()));
    }

    public static int countChanges(String message) {
        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != sos.charAt(i % 3)) count++;
        }
        return count;
    }
}
