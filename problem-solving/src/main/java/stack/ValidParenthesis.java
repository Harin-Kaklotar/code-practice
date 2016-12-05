package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Liju on 12/4/2016.
 * <p>
 * Given a string containing just the stack '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParenthesis {

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("()"));
        System.out.println(validParenthesis.isValid("["));
    }

    List<Character> stack = new LinkedList<>();

    public void push(Character c) {
        stack.add(c);
    }

    public Character pop() {
        if (stack.size() > 0)
            return stack.remove(stack.size() - 1);
        return null;
    }


    public boolean isValid(String s) {
        char[] characters = s.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '(' || characters[i] == '{' || characters[i] == '[') {
                push(characters[i]);
            } else {
                Character c = pop();
                if (c == null) return false;
                if (characters[i] == ')' && c != '(') return false;
                if (characters[i] == '}' && c != '{') return false;
                if (characters[i] == ']' && c != '[') return false;
            }
        }
        return stack.isEmpty();
    }


    public boolean isValidSoln2(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for (int i = 0; i < s.length(); i++) {
            // Push any open parentheses onto stack
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
                // Check stack for corresponding closing parentheses, false if not valid
            else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.empty();
    }


    public boolean isValidSol3(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
