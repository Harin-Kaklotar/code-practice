package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Liju on 12/8/2016.
 * <p>
 * You have an empty sequence, and you will be given  queries. Each query is one of these three types:
 * <p>
 * 1 x  -Push the element x into the stack.
 * 2    -Delete the element present at the top of the stack.
 * 3    -Print the maximum element in the stack.
 * Input Format
 * <p>
 * The first line of input contains an integer,N . The next N lines each contain an above mentioned query. (It is guaranteed that each query is valid.)
 * https://www.hackerrank.com/challenges/maximum-element
 */
public class MaxElement {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        Stack<Node> stack = new Stack<>();
        final int i = scanner.nextInt();
        for (int j = 0; j < i; j++) {
            final int query = scanner.nextInt();
            switch (query) {
                case 1:
                    final int k = scanner.nextInt();
                    if (stack.isEmpty()) {
                        stack.push(new Node(k, k));
                    }
                    else {
                        if (stack.peek().currentMax < k)
                            stack.push(new Node(k, k));
                        else
                            stack.push(new Node(stack.peek().currentMax, k));
                    }
                    break;
                case 2:
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                case 3:
                    if (!stack.isEmpty())
                        System.out.println(stack.peek().currentMax);
            }
        }
    }

    static class Node {
        Integer currentMax;
        Integer val;

        Node(Integer currentMax, Integer val) {
            this.currentMax = currentMax;
            this.val = val;
        }
    }


}
