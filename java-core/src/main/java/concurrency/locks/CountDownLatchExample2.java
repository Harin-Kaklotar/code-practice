package concurrency.locks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 *  Typical usage would be to divide a problem into N parts, describe each part with a Runnable that executes that portion
 *  and counts down on the latch, and queue all the Runnables to an Executor.
 *  When all sub-parts are complete, the coordinating thread will be able to pass through await.
 *  (When threads must repeatedly count down in this way, instead use a CyclicBarrier.)
 */
public class CountDownLatchExample2 {

    public static void main(String[] args) throws InterruptedException {
        int noOfWorkers = 10;
        CountDownLatch countDownLatch  = new CountDownLatch(noOfWorkers);
        final ExecutorService executorService = Executors.newFixedThreadPool(noOfWorkers);
        IntStream.range(0,noOfWorkers).forEach( i -> executorService.submit(new MyWorker(countDownLatch)));
        countDownLatch.await(); // wait for workers to complete
        System.out.println("All workers done");
    }
}

class MyWorker implements Runnable{
    private CountDownLatch countDownLatch;

    public MyWorker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override public void run() {
        try {
            doSomething();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doSomething() throws InterruptedException {
        System.out.println("doing something");
        Thread.sleep(1000);
        System.out.println("done");
    }
}