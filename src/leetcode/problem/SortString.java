package leetcode.problem;

public class SortString {
	/**
	 * 1370. 上升下降字符串
	 * https://leetcode-cn.com/problems/increasing-decreasing-string/
	 */
	public String sortString(String s) {
		if (s.length() < 2) {
			return s;
		}
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		while (sb.length() < s.length()) {
			for (int i = 0; i < 26; i++) {
				if (count[i] > 0) {
					sb.append((char) (i + 'a'));
					count[i]--;
				}
			}
			for (int i = 25; i > -1; i--) {
				if (count[i] > 0) {
					sb.append((char) (i + 'a'));
					count[i]--;
				}
			}
		}
		return sb.toString();
	}
}
