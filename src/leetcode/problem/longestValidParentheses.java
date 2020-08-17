package leetcode.problem;

import java.util.Stack;

public class longestValidParentheses {
    /**
     * 32
     * https://leetcode-cn.com/problems/longest-valid-parentheses/
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] mark = new int[s.length()];
        int len = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    mark[i] = 1;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.empty()) {
            mark[stack.pop()] = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (mark[i] == 1) {
                len = 0;
            } else {
                len++;
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
