package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int MAX_SIZE = 10;
        Thread producer = new Producer(queue,MAX_SIZE,"PRODUCER");
        Thread consumer = new Consumer(queue,MAX_SIZE,"CONSUMER");
        producer.start();
        consumer.start();
    }
}
class Producer extends Thread{
    private Queue<Integer> queue;
    int MAX_SIZE;
    private Random random = new Random();

    public Producer(Queue<Integer> queue, int MAX_SIZE,String name) {
        super(name);
        this.queue = queue;
        this.MAX_SIZE = MAX_SIZE;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == MAX_SIZE) {
                    try {
                        System.out.println("queue is full");
                        queue.wait(); // wait should be called on synchronized object
                    } catch (InterruptedException e) {
                    }
                }
                int i = random.nextInt();
                System.out.println(String.format("ThreadName=%s , Producer number=%d", this.getName(), i));
                queue.add(i);
                queue.notifyAll();// notify should be called on synchronized object
            }
        }
    }

}

class Consumer extends Thread{
    private Queue<Integer> queue;
    int MAX_SIZE;

    public Consumer(Queue<Integer> queue, int MAX_SIZE,String name) {
        super(name);
        this.queue = queue;
        this.MAX_SIZE = MAX_SIZE;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("queue is empty");
                        queue.wait();// wait should be called on synchronized object
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(String.format("ThreadName=%s , Consumed number=%d", this.getName(), queue.poll()));
                queue.notifyAll();// notify should be called on synchronized object
            }
        }
    }
}
