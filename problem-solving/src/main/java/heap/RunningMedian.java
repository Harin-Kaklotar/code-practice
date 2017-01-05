package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by liju on 1/2/17.
 * <p>
 * Find the running median
 * <p>
 * https://www.hackerrank.com/challenges/find-the-running-median
 * http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 */
public class RunningMedian {

    public static void main(String[] args) {
        PriorityQueue<Float> left = new PriorityQueue<>(Collections.reverseOrder()); //Max hep
        PriorityQueue<Float> right = new PriorityQueue<>(); //Min Heap

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        float median = 0.0f;

        for (int i = 0; i < n; i++) {
            float item = sc.nextFloat();

            int diff = getDiffOfHeapSize(left, right);

            switch (diff) {

                case 0: //balanced
                    if (item > median) {
                        right.add(item);
                        median = right.peek();
                    } else {
                        left.add(item);
                        median = left.peek();
                    }
                    break;

                case 1: //left heap has more elements

                    if (item < median) {
                        right.add(left.poll());
                        left.add(item);
                    } else {
                        right.add(item);
                    }
                    median = (left.peek() + right.peek()) / 2;
                    break;

                case -1: //right heap has more elements

                    if (item > median) {
                        left.add(right.poll());
                        right.add(item);
                    } else {
                        left.add(item);
                    }
                    median = (left.peek() + right.peek()) / 2;
                    break;

            }

            System.out.println(String.format("%.1f", median));
        }
    }

    private static int getDiffOfHeapSize(PriorityQueue<Float> left, PriorityQueue<Float> right) {
        if (left.size() == right.size()) return 0;
        return left.size() > right.size() ? 1 : -1;
    }
}
