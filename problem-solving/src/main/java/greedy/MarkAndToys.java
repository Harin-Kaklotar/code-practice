package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liju on 9/1/17.
 */
public class MarkAndToys {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (k >= a[i]) {
                count++;
                k -= a[i];
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
