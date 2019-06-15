package Stack;

import java.util.Stack;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                //入棧
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (s.charAt(i) == ')' && topChar != '(') {
                    return false;
                } else if (s.charAt(i) == ']' && topChar != '[') {
                    return false;
                } else if (s.charAt(i) == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
