package leetcode.problem;

import java.util.Stack;

public class ReverseOnlyLetters {
    /**
     * 917. 仅仅反转字母
     * https://leetcode-cn.com/problems/reverse-only-letters/
     */
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (((c <= 'z') && (c >= 'a')) || ((c <= 'Z') && (c >= 'A'))) {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (((c <= 'z') && (c >= 'a')) || ((c <= 'Z') && (c >= 'A'))) {
                sb.append(stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
