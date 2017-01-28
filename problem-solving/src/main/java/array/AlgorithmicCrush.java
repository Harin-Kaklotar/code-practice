package array;

import java.util.Scanner;

/**
 * Created by liju on 1/28/17.
 * <p>
 * https://www.hackerrank.com/challenges/crush
 *
 Think of the problem as a summation of subsets which produce a single vector:
 -Each subset creates a section which is incremented by c, from a to b.
 -Overlapping subsets will combine such increments
 1. Create a blank vector
 2. Increment v[a] by c
 3. Decrement v[b+1] (end of range; reset to 0) by c
 4. Repeat for all incremental queries
 Iterate through v and ouput the largest value of the sum at any given position
 */
public class AlgorithmicCrush {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long arr[] = new long[N];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long k = sc.nextLong();
            //since 0 based array and 1<=a,b<=N
            arr[a - 1] += k;
            if (b < N)
                arr[b] -= k;
        }

        long max = Long.MIN_VALUE;

        long val = 0;
        for (int i = 0; i < N; i++) {
            val += arr[i];

            if (val > max)
                max = val;
        }
        System.out.println(max);
    }
}
