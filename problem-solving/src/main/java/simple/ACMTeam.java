package simple;

import java.math.BigInteger;
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
            bs[i] = BitSet.valueOf(new BigInteger(sc.next(),2).toByteArray());
        }

        int maxSub = 0;
        int count = 0;
        for (int i = 0; i < n;  i++) {
            for (int j = i+1; j < n; j++) {
                BitSet tmpi = (BitSet)bs[i].clone();
                BitSet tmpj = (BitSet)bs[j].clone();
                tmpi.or(tmpj);
                if (tmpi.cardinality() > maxSub) {
                    maxSub = tmpi.cardinality();
                    count = 1;
                }
                else if (tmpi.cardinality() == maxSub) {
                    count++;
                }
            }
        }

        System.out.println(maxSub);
        System.out.println(count);

    }
}
