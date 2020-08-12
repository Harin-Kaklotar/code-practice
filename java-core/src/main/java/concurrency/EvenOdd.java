package concurrency;

/**
 * Created by liju on 8/12/20.
 * Print even and odd numbers using threads in java , even numbers in one thread and odd in other thread
 */
public class EvenOdd {
    private boolean printEven = true;
    private int max = 20;
    private int i = 0;

    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd();
        new Thread(() -> evenOdd.printEven()).start();
        new Thread(() -> evenOdd.printOdd()).start();

    }

    public void printEven() {
        while (i < max) {
            synchronized (this) {
                while (!printEven) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("even : num=" + i);
                printEven = false;
                i++;
                this.notifyAll();
            }
        }

    }

    public void printOdd() {
        while (i < max) {
            synchronized (this) {
                while (printEven) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("odd : num=" + i);
                printEven = true;
                i++;
                this.notifyAll();
            }
        }

    }


}


