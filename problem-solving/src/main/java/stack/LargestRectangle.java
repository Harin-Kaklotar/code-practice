package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by liju on 12/27/16.
 * <p>
 * Calculate the largest rectangle in a histogram
 * <p>
 * https://www.hackerrank.com/challenges/largest-rectangle
 */
public class LargestRectangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> position = new Stack<>();
        Stack<Integer> height = new Stack<>();
        int maxRectangleArea = Integer.MIN_VALUE;
        int startPost = 0;
        //eg. 1 2 3 1 1 0 4

        //eg. 1 5 4 3 2 1

        //eg. 1 0 1 1 0

        //eg. 1 2 3 3 2 1

        height.push(arr[0]);
        position.push(0);

        for (int i = 1; i < size; i++) {
            if (height.isEmpty() || arr[i] > height.peek()) {
                height.push(arr[i]);
                position.push(i);
            } else {
                while (!height.isEmpty()) {
                    if (arr[i] < height.peek()) {
                        int area = calArea(i, position.peek(), height.pop());
                        if (area > maxRectangleArea) maxRectangleArea = area;

                        //pop position only if current height is greater the peek
                        if (!height.isEmpty() && arr[i] <= height.peek()) {
                            position.pop();
                        }
                        if (height.isEmpty() || arr[i] > height.peek()) {
                            height.push(arr[i]);
                        }
                    } else {

                        break;
                    }
                }
            }
        }

        // process the existing stack items
        while (!height.isEmpty()) {
            int area = calArea(arr.length, position.pop(), height.pop());
            if (area > maxRectangleArea) maxRectangleArea = area;
        }

        System.out.println(maxRectangleArea);
    }

    private static int calArea(int currentPos, int startPos, int val) {
        return (currentPos - startPos) * val;
    }
}
