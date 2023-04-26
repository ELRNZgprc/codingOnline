package leetcode.problem;

import java.util.Stack;

/**
 * 2390. 从字符串中移除星号
 * https://leetcode.cn/problems/removing-stars-from-a-string/
 */
public class RemoveStars {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
