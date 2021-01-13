package leetcode.problem;

public class CanConstruct1400 {
	/**
	 * 1400. 构造 K 个回文字符串
	 * https://leetcode-cn.com/problems/construct-k-palindrome-strings/
	 */
	public boolean canConstruct(String s, int k) {
		if (s.length() < k) {
			return false;
		}
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		int odd = 0;
		for (int i = 0; i < 26; i++) {
			if (count[i] % 2 == 1) {
				odd++;
			}
		}
		return odd <= k;
	}
}
