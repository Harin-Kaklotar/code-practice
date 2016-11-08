package concurrency.locks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * Created by liju on 11/7/16.
 *
 * Example of parallel decomposition of work
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        final int[][] data = new int[3][3];
        CyclicBarrierExample cyclicBarrierExample = new CyclicBarrierExample();
        cyclicBarrierExample.solve(data);

    }

    public void solve(final int[][] data) {
        /*
         * will execute the given barrier action when the barrier with the given number of parties (threads) waiting
         * upon is tripped, performed by the last thread entering the barrier.
         */

        CyclicBarrier cyclicBarrier = new CyclicBarrier(data.length, new Runnable() {
            @Override
            public void run() {
                mergeRows();
            }

            public void mergeRows() {
                System.out.println("merge all rows");
            }
        });

        IntStream.range(0, data.length).forEach(i -> new Thread(new Worker(i, cyclicBarrier, data)).start());

    }

    class Worker implements Runnable {
        final int rowNumber;
        final CyclicBarrier cyclicBarrier;
        final int[][] data;

        public Worker(int rowNumber, CyclicBarrier cyclicBarrier, int[][] data) {
            this.rowNumber = rowNumber;
            this.cyclicBarrier = cyclicBarrier;
            this.data = data;
        }

        @Override
        public void run() {
            try {
                processRow();
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

        public void processRow() {
            System.out.println("processing row - " + rowNumber);
        }
    }

}
