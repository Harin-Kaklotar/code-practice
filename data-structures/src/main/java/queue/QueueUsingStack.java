package queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Liju on 12/4/2016.
 *
 Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 */
public class QueueUsingStack {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();


    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
            return input.isEmpty() && output.isEmpty();
    }
}
