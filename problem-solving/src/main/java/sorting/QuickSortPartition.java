package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liju on 8/11/17.
 * https://www.hackerrank.com/challenges/quicksort1
 */
public class QuickSortPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        int pivot = 0;
        int i = 1;
        List<Integer> left  = new ArrayList<>();
        List<Integer> right  = new ArrayList<>();
        while (i < n) {
            if (ar[i]<ar[pivot]) left.add(ar[i]);
            else right.add(ar[i]);
            i++;
        }
        left.stream().forEach(x -> System.out.print(x+" "));
        System.out.print(ar[pivot]+" ");
        right.stream().forEach(x -> System.out.print(x+" "));
    }
}
