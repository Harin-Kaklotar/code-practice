package locks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Here is a pair of classes in which a group of worker threads use two countdown latches:
  - The first is a start signal that prevents any worker from proceeding until the driver is ready for them to proceed;
  - The second is a completion signal that allows the driver to wait until all workers have completed.
 */
public class CounDownLatchExample1 {

    public static void main(String[] args) throws InterruptedException {
        int noOfWorkers = 10;
        CountDownLatch startLatch  = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(noOfWorkers);
        final ExecutorService executorService = Executors.newFixedThreadPool(noOfWorkers);

        IntStream.range(0,noOfWorkers).forEach( i -> executorService.submit(new Worker(startLatch,doneLatch)));
        doSomethingElse(); // dont start workers yet
        startLatch.countDown(); // trigger to start workers
        doSomethingElse();
        doneLatch.await(); // wait for workers to complete
        System.out.println("All workers done");
    }

    public static  void doSomethingElse() throws InterruptedException {
        System.out.println("Doing something else");
        Thread.sleep(2000);
    }

}

class Worker implements Runnable{
    private CountDownLatch startLatch;
    private CountDownLatch doneLatch;

    public Worker(CountDownLatch startLatch, CountDownLatch doneLatch) {
        this.startLatch = startLatch;
        this.doneLatch = doneLatch;
    }

    @Override public void run() {
        try {
            startLatch.await();
            startJob();
            doSomething();
            doneLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doSomething() throws InterruptedException {
        System.out.println("doing something");
        Thread.sleep(1000);
        System.out.println("done");
    }

    public void startJob(){
        System.out.println("Job started");
    }
}
