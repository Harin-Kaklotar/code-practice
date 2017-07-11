package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/10/17.
 * https://www.hackerrank.com/challenges/angry-professor
 */
public class AngryProf {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int noOfStud = sc.nextInt();
            int minStud = sc.nextInt();
            int onTime = 0;
            for (int j = 0; j < noOfStud; j++) {
                if (sc.nextInt() <= 0) onTime++;
            }
            System.out.println(onTime>=minStud ? "NO" :"YES");
        }
    }

}
