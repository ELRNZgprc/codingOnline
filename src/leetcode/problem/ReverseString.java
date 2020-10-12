package leetcode.problem;

public class ReverseString {
	/**
	 * 344. 反转字符串
	 * https://leetcode-cn.com/problems/reverse-string/
	 */
	public void reverseString(char[] s) {
		int n = s.length;
		for (int i = 0; i < n / 2; ++i) {
			int j = n - 1 - i;
			char k = s[i];
			s[i] = s[j];
			s[j] = k;
		}
	}
}
