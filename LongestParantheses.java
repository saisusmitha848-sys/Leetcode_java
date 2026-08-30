import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Base index before the valid substring
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                // Store index of '('
                stack.push(i);
            } else {
                // Remove matching '('
                stack.pop();

                if (stack.isEmpty()) {
                    // No matching '('
                    stack.push(i);
                } else {
                    // Calculate valid parentheses length
                    int length = i - stack.peek();
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}

