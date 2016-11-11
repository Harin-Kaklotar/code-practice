package concurrency;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by Liju on 11/10/2016.
 */
public class ThreadLocalExample implements Runnable {
    // Atomic integer containing the next thread ID to be assigned
    private static AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    // Returns the current thread's unique ID, assigning it if necessary
    public static Integer getThreadId(){
      return threadId.get();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("My Thread ID  "+getThreadId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        final ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        //since there are 3 threads in the created thread pool  , thread id range from 0-2
        IntStream.range(0,5).forEach(i -> executorService.submit(threadLocalExample));
    }

}
