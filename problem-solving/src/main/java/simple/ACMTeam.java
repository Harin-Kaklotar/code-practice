package simple;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by liju on 7/13/17.
 * https://www.hackerrank.com/challenges/acm-icpc-team
 */
public class ACMTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        BitSet[] bs = new BitSet[n];

        //convert input string to bitset
        for (int i = 0; i < n;  i++) {
            StringBuilder vector  = new StringBuilder(sc.next());
            bs[i] = BitSet.valueOf(new long[]{Long.parseLong(vector.reverse().toString(),2)});
        }

        int maxSub = 0;
        int count = 0;
        for (int i = 0; i < n;  i++) {
            BitSet tmp = bs[i];
            for (int j = i+1; j < n; j++) {
                tmp = bs[i];
                tmp.or(bs[j]);
                if (tmp.cardinality() > maxSub) {
                    maxSub = tmp.cardinality();
                    count = 1;
                }
                else if (tmp.cardinality() == maxSub) {
                    count++;
                }
            }
        }

        System.out.println(maxSub);
        System.out.println(count);

    }
}
