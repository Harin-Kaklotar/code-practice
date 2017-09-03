package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liju on 8/12/17.
 * https://www.hackerrank.com/challenges/closest-numbers
 */
public class ClosestNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        Arrays.sort(ar);

        int min = Integer.MAX_VALUE;
        List<Integer> nums = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int diff = Math.abs(ar[i] - ar[i - 1]);
            if (diff < min) {
                nums.clear();
                min = diff;
                nums.add(ar[i-1]);
                nums.add(ar[i]);
            }else if (diff == min){
                nums.add(ar[i-1]);
                nums.add(ar[i]);
            }
        }

        nums.stream().forEach(e -> System.out.print(e + " "));
    }

}
