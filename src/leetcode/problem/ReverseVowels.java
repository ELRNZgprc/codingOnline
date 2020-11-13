package leetcode.problem;

import java.util.Stack;

public class ReverseVowels {
	/**
	 * 345. 反转字符串中的元音字母
	 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
	 */
	public String reverseVowels(String s) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (isVowel(c)) {
				stack.add(c);
			}
		}
		for (char c : s.toCharArray()) {
			if (isVowel(c)) {
				sb.append(stack.pop());
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	boolean isVowel(char c) {
		return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u' || c == 'A' || c == 'O' || c == 'E' || c == 'I'
				|| c == 'U';
	}
}
