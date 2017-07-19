package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/15/17.
 * https://www.hackerrank.com/challenges/lisa-workbook/problem
 */
public class LisaWorkbook {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfChap = sc.nextInt();
        int maxProbsPerPage = sc.nextInt();


        int[] probsPerChap = new int[noOfChap];

        for (int i = 0; i < probsPerChap.length; i++) {
            probsPerChap[i] = sc.nextInt();
        }


        int specialProb = 0;
        int page = 1;
        for (int i = 0; i < noOfChap; i++) {
            for (int j = 1; j <= probsPerChap[i]; j++) {
                if (j==page) specialProb++;
                if (j%maxProbsPerPage==0 && j!=probsPerChap[i]) page++;
            }
            page++;
        }

        System.out.println(specialProb);
    }
}
