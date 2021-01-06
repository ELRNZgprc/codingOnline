package leetcode.problem;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {
	/**
	 * 151. 翻转字符串里的单词
	 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
	 */
	public String reverseWords(String s) {
		String[] words = s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}
}
