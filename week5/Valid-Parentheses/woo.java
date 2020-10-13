package week5.ValidParentheses;

import java.util.Stack;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("]"));
        System.out.println(isValid("(])"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                switch (c) {
                    case ')':
                        if (stack.peek() == '(') stack.pop();
                        else stack.push(c);
                        break;
                    case '}':
                        if (stack.peek() == '{') stack.pop();
                        else stack.push(c);
                        break;
                    case ']':
                        if (stack.peek() == '[') stack.pop();
                        else stack.push(c);
                        break;
                }
            }
        }

        return stack.isEmpty();
    }
}
