package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liju on 8/22/17.
 * https://www.hackerrank.com/challenges/luck-balance
 *
 */
public class LuckBalance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        List<Integer> importantContest = new ArrayList<>();
        List<Integer> unimportantContest = new ArrayList<>();
         for (int i = 0; i < n; i++) {
             int l = sc.nextInt();
             int t  = sc.nextInt();
             if (t==1)
                 importantContest.add(l);
             else
                 unimportantContest.add(l);
        }

        Collections.sort(importantContest);

        int total=0;

        for (int i = 0,reqWins=Math.max(importantContest.size()-k,0); i < importantContest.size(); i++) {
            if (reqWins==0)
                total += importantContest.get(i);
            else {
                total -= importantContest.get(i);
                reqWins--;
            }
        }

        for (int i = 0; i < unimportantContest.size(); i++) {
            total += unimportantContest.get(i);
        }

        System.out.println(total);
    }
}
