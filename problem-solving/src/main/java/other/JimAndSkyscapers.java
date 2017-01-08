package other;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by liju on 1/7/17.
 * <p>
 * https://www.hackerrank.com/challenges/jim-and-the-skyscrapers
 */
public class JimAndSkyscapers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> scappers = new Stack<>();
        Stack<Integer> count = new Stack<>();
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (scappers.empty() || scappers.peek() > input) {
                scappers.push(input);
                count.push(1);
            } else if (!scappers.isEmpty() && scappers.peek() == input) {
                count.push(count.pop() + 1);
            } else {
                boolean currentElementAdded = false;
                while (!scappers.isEmpty()) {
                    Integer top = scappers.peek();
                    if (top < input) {
                        scappers.pop();
                        result = result.add(combinations(count.pop()));
                        continue;
                    }
                    if (top == input) {
                        count.push(count.pop() + 1);
                        currentElementAdded = true;
                        break;
                    }
                    if (top > input) {
                        scappers.push(input);
                        count.push(1);
                        currentElementAdded = true;
                        break;
                    }
                }
                if (!currentElementAdded) {
                    scappers.push(input);
                    count.push(1);
                }
            }
        }
        //process all the stacked items
        while (!count.isEmpty()) {
            Integer top = count.pop();
            if (top > 1) {
                result = result.add(combinations(top));
            }
        }
        System.out.println(result);
    }

    private static BigInteger combinations(int n) {
        return BigInteger.valueOf(n).multiply(BigInteger.valueOf(n - 1));
    }

}
