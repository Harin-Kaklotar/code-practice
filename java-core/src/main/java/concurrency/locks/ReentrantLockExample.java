package concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Created by Liju on 11/6/2016.
 */
public class ReentrantLockExample {
    int count = 0;
    ReentrantLock reentrantLock = new ReentrantLock();

    public int incrementAndGet() {
        reentrantLock.lock();
        try {
            count++;
        } finally {
            reentrantLock.unlock();
        }
        return count;
    }

    public void printCount() {
        System.out.println(count);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        IntStream.range(0, 1000).forEach(i -> executorService.submit(reentrantLockExample::incrementAndGet));
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
        reentrantLockExample.printCount(); //1000
    }
}
