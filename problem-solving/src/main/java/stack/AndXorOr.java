package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by liju on 12/24/16.

 https://www.hackerrank.com/challenges/and-xor-or
 */
public class AndXorOr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int S  = Integer.MIN_VALUE;
        Stack<Integer> stack  = new Stack<>();

        for (int i = 0; i < n; i++) {
                while (!stack.isEmpty()){
                    Integer top  = stack.peek();
                    int tmpS  = calculateS(arr[i],top);
                    if (tmpS>S) S = tmpS;
                    if (arr[i] < top) stack.pop();
                    else break;
                }
                stack.push(arr[i]);
        }

        System.out.println(S);
    }

    private static int calculateS(int i, int top) {
        return (((i&top)^(i|top))&(i^top));
    }
}
