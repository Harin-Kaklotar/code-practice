package locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by Liju on 11/6/2016.
 */
public class SynchronizedExample {
    int count = 0;

    public synchronized int incrementAndGet() {
        return count++;
    }

    // another way to synchronize on this object
    public int incrementAndGetSynchronized(){
        synchronized (this){
            return  count++;
        }
    }

    public void printCount() {
        System.out.println(count);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final SynchronizedExample synchronizedExample = new SynchronizedExample();
        IntStream.range(0, 1000).forEach(i -> executorService.submit(synchronizedExample::incrementAndGet));
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
        synchronizedExample.printCount(); //1000
    }
}
