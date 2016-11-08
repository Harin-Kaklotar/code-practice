package concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by liju on 11/8/16.
 */
public class VolatileExample {

}


/*
 Not Thread-safe - incorrect implementation.
*/
final class Job1 implements Runnable {

    private boolean shutdown = false;

    @Override
    public void run() {
        while (!shutdown) {
            try {
                // do stuff
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // reset interrupt
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutDown() {
        //this change might not be visible to other threads
        shutdown = true;
    }
}


/*
 Thread-safe - correct implementation.
 Using volatile variable
*/
final class Job2 implements Runnable {

    private volatile boolean shutdown = false;

    @Override
    public void run() {
        while (!shutdown) {
            try {
                // do stuff
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // reset interrupt
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutDown() {
        shutdown = true;
    }
}


/*
 Thread-safe - correct implementation.
 Using Atomic variable
*/
final class Job3 implements Runnable {

    private AtomicBoolean shutdown = new AtomicBoolean(false);

    @Override
    public void run() {
        while (!shutdown.get()) {
            try {
                // do stuff
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // reset interrupt
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutDown() {
        shutdown.set(true);
    }
}


/*
 Thread-safe - correct implementation.
 Using synchronized
*/
final class Job4 implements Runnable {

    private boolean shutdown = false;

    @Override
    public void run() {
        while (!isShutDown()) {
            try {
                // do stuff
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // reset interrupt
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized boolean isShutDown() {
        return shutdown;
    }

    public synchronized void shutDown() {
        shutdown = true;
    }
}