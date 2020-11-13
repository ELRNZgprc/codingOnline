package leetcode.problem;

public class NumSub {
	/**
	 * 1513. 仅含 1 的子串数
	 * https://leetcode-cn.com/problems/number-of-substrings-with-only-1s/
	 */
	public int numSub(String s) {
		long ans = 0;
		int cur = 0;
		for (char c : s.toCharArray()) {
			if (c == '1') {
				cur++;
			} else {
				cur = 0;
			}
			ans = (ans + cur) % 1000000007;
		}
		return (int) ans;
	}
}
