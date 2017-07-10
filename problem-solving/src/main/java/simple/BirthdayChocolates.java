package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/the-birthday-bar
 */
public class BirthdayChocolates {

    static int solve(int n, int[] s, int d, int m) {
        // Complete this function
        int sum = 0, total = 0;

        int tail = 0, head = 0;
        int nums = m;

        while (head < s.length) {
            sum += s[head];
            head++;
            nums--;

            while (tail <= head && sum > d) {
                sum -= s[tail];
                tail++;
                nums++;
            }
            if (sum == d && nums == 0) {
                total++;
                nums++;
                sum -= s[tail];
                tail++;
            }
        }

        return total;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for (int s_i = 0; s_i < n; s_i++) {
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
