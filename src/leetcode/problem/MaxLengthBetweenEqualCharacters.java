package leetcode.problem;

public class MaxLengthBetweenEqualCharacters {
	/**
	 * 1624. 两个相同字符之间的最长子字符串
	 * https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters/
	 */
	public int maxLengthBetweenEqualCharacters(String s) {
		int ans = -1;
		for (char c : s.toCharArray()) {
			ans = Math.max(ans, s.lastIndexOf(c) - s.indexOf(c) - 1);
		}
		return ans;
	}
}
