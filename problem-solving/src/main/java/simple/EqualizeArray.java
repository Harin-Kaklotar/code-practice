package simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liju on 7/13/17.
 *
 * https://www.hackerrank.com/challenges/equality-in-a-array
 *
 */
public class EqualizeArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
                if (map.get(x) > max)
                    max = map.get(x);
            } else {
                map.put(x, 1);
            }
        }
        System.out.println(n - max);
    }
}
