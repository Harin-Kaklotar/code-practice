package greedy;

import java.util.Scanner;

/**
 * Created by liju on 8/23/17.
 * https://www.hackerrank.com/challenges/beautiful-pairs/problem
 */
public class BeautifulPairs {



    //TODO

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int maxDisjointPair = 0;
        boolean changed = false;
        for (int i = 0; i < n; i++) {

            if (a[i] == b[i]) maxDisjointPair++;
            else if (!changed) {
                maxDisjointPair++;
                changed = true;
            }

        }

        //if all pairs are equal
        if (!changed) maxDisjointPair--;

        System.out.println(maxDisjointPair);
    }
}
