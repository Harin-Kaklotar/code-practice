package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by liju on 12/30/16.
 * <p>
 * https://www.hackerrank.com/challenges/truck-tour
 */
public class TruckTour {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<PetrolPump> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new PetrolPump(i, sc.nextInt(), sc.nextInt()));
        }

        int start = 0, gasRemainig = 0, visited = 0;
        while (visited < n) {
            PetrolPump pump = queue.poll();
            gasRemainig += pump.gasIn - pump.distanceToNext;
            if (gasRemainig < 0) {
                visited = 0;
                start = queue.peek().position;
                gasRemainig = 0;
            } else {
                visited++;
            }
            queue.offer(pump);
        }
        System.out.println(start);
    }


    static class PetrolPump {
        int position;
        int gasIn;
        int distanceToNext;

        public PetrolPump(int position, int gasIn, int distanceToNext) {
            this.position = position;
            this.gasIn = gasIn;
            this.distanceToNext = distanceToNext;
        }
    }
}
