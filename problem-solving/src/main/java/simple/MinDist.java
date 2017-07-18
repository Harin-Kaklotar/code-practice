package simple;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by liju on 7/15/17.
 * https://www.hackerrank.com/challenges/minimum-distances/problem
 */
public class MinDist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, SortedSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int index = new Integer(i);
            if (map.get(x) != null) map.get(x).add(i);
            else map.put(x, new TreeSet<Integer>() {{
                add(index);
            }});
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, SortedSet<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                Iterator<Integer> it = entry.getValue().iterator();
                int y = Math.abs(it.next() - it.next());
                if (y < min) min = y;
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1:min);
    }
}
