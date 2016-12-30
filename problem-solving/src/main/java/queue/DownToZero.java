package queue;

import java.util.*;

/**
 * Created by liju on 12/29/16.
 */
public class DownToZero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[] numbers = new int[q];
        for (int i = 0; i < q; i++) {
            numbers[i] = sc.nextInt();
        }

        Map<Integer, Integer> computedNumbers = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < numbers.length; i++) {
            queue.clear();
            queue.offer(new Pair(numbers[i], 1, 0));
            int minStep = reduceN(queue);
            System.out.println(minStep);
        }

    }

    private static int reduceN(Queue<Pair> queue) {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int max = Math.max(pair.x, pair.y);
            if (max == 1) {
                return (pair.step + 1);
            }
            pushFactorsOfNum(pair, queue);
        }
        return -1;
    }

    private static void pushFactorsOfNum(Pair pair, Queue<Pair> queue) {
        int max = Math.max(pair.x, pair.y);
        for (int i = 2; i <= Math.sqrt(max); i++) {
            int rem = max % i;
            if (rem == 0) {
                queue.offer(new Pair(max / i, i, pair.step + 1));
            }
        }
        queue.offer(new Pair(max - 1, 1, pair.step + 1));
    }

    static class Pair {
        int x, y, step;

        public Pair(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}
