/*
package stack;

import java.util.Scanner;
import java.util.Stack;

*/
/**
 * Created by Liju on 12/13/2016. There are N plants in a garden. Each of these plants has been added with some amount
 * of pesticide. After each day, if any plant has more pesticide than the plant at its left, being weaker than the left
 * one, it dies. You are given the initial values of the pesticide in each plant. Print the number of days after which
 * no plant dies, i.e. the time after which there are no plants with more pesticide content than the plant to their
 * left.
 * <p>
 * Sample Input
 * <p>
 * 7 6 5 8 4 7 10 9 Sample Output
 * <p>
 * 2 Explanation
 * <p>
 * Initially all plants are alive.
 * <p>
 * Plants = {(6,1), (5,2), (8,3), (4,4), (7,5), (10,6), (9,7)}
 * <p>
 * Plants[k] = (i,j) => jth plant has pesticide amount = i.
 * <p>
 * After the 1st day, 4 plants remain as plants 3, 5, and 6 die.
 * <p>
 * Plants = {(6,1), (5,2), (4,4), (9,7)}
 * <p>
 * After the 2nd day, 3 plants survive as plant 7 dies.
 * <p>
 * Plants = {(6,1), (5,2), (4,4)}
 * <p>
 * After the 3rd day, 3 plants survive and no more plants die.
 * <p>
 * Plants = {(6,1), (5,2), (4,4)}
 * <p>
 * After the 2nd day the plants stop dying.
 *//*

public class PoisonousPlants {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static Stack<Integer> nonEmptyStack;
    static Stack<Integer> emptyStack;
    static boolean killedAny = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            stack1.push(arr[i]);
        }
        System.out.println(removePoisonousPlants(0));
    }

    static int removePoisonousPlants(int day) {
        int tmp = day;
        if (!stack1.isEmpty()) {
            nonEmptyStack = stack1;
            emptyStack = stack2;
        } else {
            nonEmptyStack = stack2;
            emptyStack = stack1;
        }
        compareAndKill(null);
        if (killedAny)
            tmp++;

        killedAny = false;
        if (tmp == day) {
            return day;
        }
        return removePoisonousPlants(tmp);
    }

    static void compareAndKill(Integer prev) {
        if (!nonEmptyStack.isEmpty()) {
            final Integer top = nonEmptyStack.pop();
            if (!nonEmptyStack.isEmpty()) {
                compareAndKill(top);
            }
            if (prev == null || top <= prev) {
                emptyStack.push(top);
            } else {
                killedAny = true;
            }
        }
    }

}
*/
