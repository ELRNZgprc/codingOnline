package leetcode.problem;

import java.util.Stack;

public class isValid1003 {
    /**
     * 1003
     * https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/
     */
    public boolean isValid1003(String S) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            if (S.charAt(i) == 'a') {
                if (i >= S.length() - 2) {
                    return false;
                }
                if (S.charAt(i + 1) != 'b') {
                    stack.push(1);
                    i++;
                } else if (S.charAt(i + 2) != 'c') {
                    stack.push(2);
                    i += 2;
                } else {
                    i += 3;
                }
            } else if (S.charAt(i) == 'b') {
                if (i >= S.length() - 1) {
                    return false;
                }
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != 1) {
                    return false;
                }
                if (S.charAt(i + 1) != 'c') {
                    stack.push(2);
                    i++;
                } else {
                    i += 2;
                }
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != 2) {
                    return false;
                }
                i++;
            }
        }
        return stack.isEmpty();
    }
}
