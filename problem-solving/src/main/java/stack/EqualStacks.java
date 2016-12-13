package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by liju on 12/12/16.
 */
public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
            sum1 += h1[h1_i];
        }
        for (int h1_i = n1 - 1; h1_i >= 0; h1_i--) {
            stack1.push(h1[h1_i]);
        }
        int h2[] = new int[n2];
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
            stack2.push(h2[h2_i]);
            sum2 += h2[h2_i];
        }
        for (int h2_i = n2 - 1; h2_i >= 0; h2_i--) {
            stack2.push(h2[h2_i]);
        }
        int h3[] = new int[n3];
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
            stack3.push(h3[h3_i]);
            sum3 += h3[h3_i];
        }

        for (int h3_i = n3 - 1; h3_i >= 0; h3_i--) {
            stack3.push(h3[h3_i]);
        }

        System.out.println(remove(sum1, sum2, sum3, stack1, stack2, stack3));
    }

    static int remove(int sum1, int sum2, int sum3, Stack stack1, Stack stack2, Stack stack3) {
        if (stack1.isEmpty() || stack2.empty() || stack3.isEmpty())
            return 0;
        if (sum1 == sum2 && sum2 == sum3)
            return sum1;
        if (sum1 >= sum2 && sum1 >= sum3) {
            sum1 -= (Integer) stack1.pop();
        } else if (sum2 >= sum1 && sum2 >= sum3) {
            sum2 -= (Integer) stack2.pop();
        } else {
            sum3 -= (Integer) stack3.pop();
        }
        return remove(sum1, sum2, sum3, stack1, stack2, stack3);
    }
}
