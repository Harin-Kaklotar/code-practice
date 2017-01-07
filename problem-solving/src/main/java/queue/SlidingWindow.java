package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by liju on 1/7/17.
 * <p>
 * https://www.hackerrank.com/challenges/queries-with-fixed-length
 */
public class SlidingWindow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int result = calculateMinOfMaxOfAllSlidingWindows(A, sc.nextInt());
            System.out.println(result);
        }
    }

    private static int calculateMinOfMaxOfAllSlidingWindows(int[] A, int k) {
        int result = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {

            //if deque.peek()==i-k means dequeue peek is of previous window , remove it
            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.removeFirst();
            }

            // remove all the elements smaller than current one from dequeu's back (this maintains the elements in increasing order
            while (!deque.isEmpty() && A[i] > A[deque.getLast()]) {
                deque.removeLast();
            }
            deque.offer(i);

            // get the current window's max ( once i reaches K-1 , every iteration is a new window
            if (i + 1 >= k) {
                result = result > A[deque.peek()] ? A[deque.peek()] : result;
            }
        }
        return result;
    }
}
