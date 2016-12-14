package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Liju on 12/13/2016.
 * <p>
 * In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string S . You must perform  Q operations of the following  types:
 * <p>
 * append(W) - Append string W to the end of .
 * delete(k) - Delete the last K  characters of String S .
 * print(k) - Print the  Kth character of S.
 * undo - Undo the last (not previously undone) operation of type  1 or 2 , reverting S to the state it was in prior to that operation.
 */

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> editorStack = new Stack<>();
        editorStack.push("");
        final int noOfOps = sc.nextInt();
        for (int i = 0; i < noOfOps; i++) {
            final int operation = sc.nextInt();
            switch (operation) {
                //append
                case 1:
                    editorStack.push(editorStack.peek() + sc.next());
                    break;
                //delete
                case 2:
                    final String string = editorStack.peek();
                    editorStack.push(string.substring(0, string.length() - sc.nextInt()));
                    break;
                //print
                case 3:
                    System.out.println(editorStack.peek().charAt(sc.nextInt() - 1));
                    break;
                //undo
                case 4:
                    editorStack.pop();
                    break;
                default: //nothing
            }
        }
    }


}
