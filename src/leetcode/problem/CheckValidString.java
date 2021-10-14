package leetcode.problem;

import java.util.Stack;

/**
 * 678. 有效的括号字符串
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 */
public class CheckValidString {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.add(i);
            } else if (s.charAt(i) == '*') {
                star.add(i);
            } else if (!left.empty()) {
                left.pop();
            } else if (!star.empty()) {
                star.pop();
            } else {
                return false;
            }
        }
        while ((!left.empty()) && (!star.empty())) {
            if (left.peek() > star.peek()) {
                return false;
            }
            left.pop();
            star.pop();
        }
        return left.empty();
    }
}
