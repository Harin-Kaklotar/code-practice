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

        Map<Integer, Integer> memoize = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < numbers.length; i++) {
            queue.offer(new Pair(numbers[i], 0));
            int minStep = processNumber(queue, memoize);
            System.out.println(minStep);
            memoize.clear();
            queue.clear();
        }

    }

    private static int processNumber(Queue<Pair> queue, Map<Integer, Integer> memoize) {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (memoize.containsKey(pair.num) && memoize.get(pair.num) < pair.step)
                continue;

            if (pair.num == 1) {
                return (pair.step + 1);
            }
            reduceNumber(pair, queue, memoize);
        }
        return -1;
    }

    private static void reduceNumber(Pair pair, Queue<Pair> queue, Map<Integer, Integer> memoize) {

        for (int i = 2; i <= Math.sqrt(pair.num); i++) {
            int rem = pair.num % i;
            if (rem == 0) {
                //int max = Math.max(i, pair.num / i); // no need to compare ,later is always the max
                int max = pair.num / i;
                int step = pair.step + 1;
                if (memoize.containsKey(max) && memoize.get(max) < step)
                    continue;

                memoize.put(max, step);
                queue.offer(new Pair(max, step));
            }
        }

        int num = pair.num - 1;
        int step = pair.step + 1;
        if (memoize.containsKey(num) && memoize.get(num) < step) return;

        memoize.put(num, step);
        queue.offer(new Pair(num, step));
    }

    static class Pair {
        int num, step;

        public Pair(int num, int step) {
            this.num = num;
            this.step = step;
        }
    }
}
