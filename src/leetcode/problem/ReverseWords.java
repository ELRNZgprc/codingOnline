package leetcode.problem;

public class ReverseWords {
	/**
	 * 186. 翻转字符串里的单词 II
	 * https://leetcode-cn.com/problems/reverse-words-in-a-string-ii/
	 */
	public void reverseWords(char[] s) {
		final int N = s.length;
		int start = 0;
		for (int i = 0; i < N; i++) {
			if (s[i] == ' ') {
				reverse(s, start, i - 1);
				start = i + 1;
			}
		}
		reverse(s, start, N - 1);
		reverse(s, 0, N - 1);
	}

	private void reverse(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}
}
