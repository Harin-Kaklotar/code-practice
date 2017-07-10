package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/counting-valleys
 */
public class CountingValleys {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalSteps = sc.nextInt();
        char[] steps;
        steps = sc.next().toCharArray();
        if (totalSteps != steps.length) throw new IllegalArgumentException("invalid number of steps");

        int seaLevel = 0;
        int noOfValleys = 0;
        for (int i = 0; i < steps.length; i++) {
            if (steps[i] == 'U') {
                if (seaLevel == -1) noOfValleys++;
                seaLevel++;
            } else if (steps[i] == 'D') {
                seaLevel--;
            } else {
                throw new IllegalArgumentException("Invalid step type");

            }
        }
        System.out.println(noOfValleys);
    }
}
