package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by liju on 12/24/16.
 * <p>
 * https://www.hackerrank.com/challenges/waiter
 */
public class Waiter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        List<Integer> primes = new ArrayList<>(Q);
        List<Stack<Integer>> bStacks = new ArrayList<>();
        Stack<Integer> aStack1 = new Stack<>();
        Stack<Integer> aStack2 = new Stack<>();
        Stack<Integer> nonEmpty;
        Stack<Integer> empty;

        populateQPrimes(primes, Q);

        for (int i = 0; i < N; i++) {
            aStack1.push(sc.nextInt());
        }
        nonEmpty = aStack1;
        empty = aStack2;

        for (int i = 0; i < Q; i++) {
            bStacks.add(new Stack<>());
            while (!nonEmpty.isEmpty()) {
                Integer poped = nonEmpty.pop();
                if (poped % primes.get(i) == 0) {
                    bStacks.get(i).push(poped);
                } else {
                    empty.push(poped);
                }
            }
            Stack tmp = nonEmpty;
            nonEmpty = empty;
            empty = tmp;
        }


        bStacks.stream().forEach(stack -> {
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        });
        while (!nonEmpty.isEmpty()) {
            System.out.println(nonEmpty.pop());
        }
    }

    private static void populateQPrimes(List<Integer> primes, int q) {
        int candidate = 2;
        for (int i = 0; i < q; i++) {
            while (true) {
                if (isPrime(candidate)) {
                    primes.add(candidate);
                    candidate++;
                    break;
                }
                candidate++;
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        int step = 4, m = (int) Math.sqrt(n) + 1;
        for (int i = 5; i < m; step = 6 - step, i += step) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
