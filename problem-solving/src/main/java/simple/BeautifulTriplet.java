package simple;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by liju on 7/15/17.
 * https://www.hackerrank.com/challenges/beautiful-triplets
 */
public class BeautifulTriplet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        Set<Integer> seq = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            seq.add(sc.nextInt());
        }

        int count = 0;
        for (int i : seq) {
            if (seq.contains(i + d) && seq.contains(i + 2 * d)) count++;
        }
        System.out.println(count);
    }
}
