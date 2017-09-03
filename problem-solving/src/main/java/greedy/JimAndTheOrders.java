package greedy;

import java.util.*;

/**
 * Created by liju on 9/2/17.
 * <p>
 * https://www.hackerrank.com/challenges/jim-and-the-orders/problem
 */
public class JimAndTheOrders {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int finishTime = sc.nextInt() + sc.nextInt();
            if (map.containsKey(finishTime)) {
                map.get(finishTime).add(i + 1);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i + 1);
                map.put(finishTime, list);
            }
        }

        map.values().stream().forEach(list -> list.stream().forEach(i -> System.out.print(i + " ")));
    }
}
