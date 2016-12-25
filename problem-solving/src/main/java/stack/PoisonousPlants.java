/*
package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

*/
/**
 * Created by Liju on 12/13/2016.
 * There are N  plants in a garden. Each of these plants has been added with some amount of pesticide. After each day, if any plant has more pesticide than the plant at its left, being weaker than the left one, it dies. You are given the initial values of the pesticide in each plant.
 * Print the number of days after which no plant dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.
 * <p>
 * Sample Input
 * <p>
 * 7
 * 6 5 8 4 7 10 9
 * Sample Output
 * <p>
 * 2
 * Explanation
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
    static boolean killedAny = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            stack1.push(sc.nextInt());
        }
        System.out.println(removePoisonousPlants(0));
    }


    static int removePoisonousPlants(int day) {
        int tmp = day;
        boolean incrementDay = false;
        while (!stack1.isEmpty()) {
            final Integer top = stack1.pop();
            if (!stack1.isEmpty()) {
                if (top <= stack1.peek()) {
                    stack2.add(top);
                } else {
                    if (!incrementDay)
                        incrementDay = true;
                }
            } else {
                stack2.add(top);
            }
        }

        if (incrementDay)
            tmp++;

        incrementDay = false;

        if (!stack2.isEmpty()) stack1.push(stack2.pop());
        incrementDay = remove();

        if (incrementDay)
            tmp++;

        if (tmp == day) {
            return day;
        }
        return removePoisonousPlants(tmp);
    }

    static int compareAndKill(Integer prev) {
        if (stack2.isEmpty()) { killedAny = false; return -1;}

        final Integer top = stack2.pop();
        if (stack2.isEmpty()) {
            if (top<=prev) {
                stack1.push(top);
                return prev;
            }else {
                killedAny=true;
            }
        }



        if (!stack2.isEmpty()) {
            final Integer top = stack2.pop();

        }
    }
}

}
*/
