package queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by liju on 12/28/16.
 * <p>
 * https://www.hackerrank.com/challenges/queue-using-two-stacks
 */
public class QueueUsingStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();

        Queue queue = new Queue();
        for (int i = 0; i < queries; i++) {
            int q = sc.nextInt();
            switch (q) {
                case 1:
                    int item = sc.nextInt();
                    queue.enqueue(item);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;

                default:
                    throw new IllegalArgumentException();
            }
        }
    }


    static class Queue {
        Stack<Integer> peekStack = new Stack<>();
        Stack<Integer> pushStack = new Stack<>();

        public void enqueue(int item) {
            pushStack.push(item);
        }

        public int dequeue() {
            peek();
            return peekStack.pop();
        }

        public int peek() {
            if (peekStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    peekStack.push(pushStack.pop());
                }
            }
            return peekStack.peek();
        }
    }
}
