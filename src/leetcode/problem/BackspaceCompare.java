package leetcode.problem;

import java.util.Stack;

public class BackspaceCompare {
	/**
	 * 844. 比较含退格的字符串
	 * https://leetcode-cn.com/problems/backspace-string-compare/
	 */
	public boolean backspaceCompare(String S, String T) {
		int n1 = S.length(), n2 = T.length();
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		for (int i = 0; i < n1; i++) {
			if (S.charAt(i) != '#') {
				stack1.push(S.charAt(i));
			} else if (!stack1.isEmpty()) {
				stack1.pop();
			}
		}
		for (int i = 0; i < n2; i++) {
			if (T.charAt(i) != '#') {
				stack2.push(T.charAt(i));
			} else if (!stack2.isEmpty()) {
				stack2.pop();
			}
		}
		if (stack1.size() != stack2.size()) {
			return false;
		}
		while (!stack1.isEmpty()) {
			if (stack1.pop() != stack2.pop()) {
				return false;
			}
		}
		return true;
	}
}
