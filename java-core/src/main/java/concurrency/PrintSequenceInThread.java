package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liju on 8/12/20.
 * <p>
 * You are given 3 threads. You need to print sequence using these 3 threads.You need to print in natural order up to MAX.
 */
public class PrintSequenceInThread {

    public static void main(String[] args) {
        PrintSequenceInThread o = new PrintSequenceInThread();
        Object lock = new Object();
        Thread t1 = new Thread(new SequencePrinter(0, lock));
        Thread t2 = new Thread(new SequencePrinter(1, lock));
        Thread t3 = new Thread(new SequencePrinter(2, lock));
        t1.start();
        t2.start();
        t3.start();
    }

    static class SequencePrinter implements Runnable {
        private int threadId;
        private int MAX = 20;
        private static int i = 0;
        private Object lock; /// or use class level lock if we don't want to pass in constructor i.e. static lock

        public SequencePrinter(int threadId, Object lock) {
            this.threadId = threadId;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (i < MAX) {
                synchronized (lock) {
                    while (i % 3 != threadId) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " num=" + i);
                    i++;
                    lock.notifyAll();
                }
            }
        }
    }

}
