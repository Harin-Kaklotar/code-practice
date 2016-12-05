package stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Liju on 12/1/2016.
 * <p>
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * <p>
 * Use only queue operations
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class StackUsingQueue {

    private Queue<Integer> queue = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        //add the new element to the queue
        queue.add(x);
        //now poll each exisiting element except the new one and add in again to the queue
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {

        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }

}
