package heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by liju on 12/30/16.
 * <p>
 * https://www.hackerrank.com/challenges/jesse-and-cookies
 * <p>
 * Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value K. To do this, Jesse repeatedly mixes two cookies with the least sweetness. He creates a special combined cookie with:
 * <p>
 * sweetness  = ( 1 * Least sweet cookie  + 2 *  2nd least sweet cookie).
 * <p>
 * He repeats this procedure until all the cookies in his collection have a sweetness >=K .
 * You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness >=K . Print -1 if this isn't possible.
 */
public class JessesCookie {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfCookies = sc.nextInt();
        int K = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < noOfCookies; i++) {
            pq.add(sc.nextInt());
        }
        int noOfOperations = 0;

        while (pq.size() > 1 && pq.peek() < K) {
            int least = pq.poll();
            int secondLeast = pq.poll();
            int newCookie = 1 * least + 2 * secondLeast;
            pq.add(newCookie);
            noOfOperations++;
        }

        if (pq.peek() >= K) {
            System.out.println(noOfOperations);
        } else {
            System.out.println(-1);
        }
    }
}
