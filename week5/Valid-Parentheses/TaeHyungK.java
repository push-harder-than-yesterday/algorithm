package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println("result: " + isValid(s));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);

            if (item == '(' || item == '{' || item == '[') {
                stack.push(item);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((top == '(' && item != ')')
                        || (top == '{' && item != '}')
                        || (top == '[' && item != ']')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
