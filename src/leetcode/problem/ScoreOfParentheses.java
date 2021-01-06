package leetcode.problem;

public class ScoreOfParentheses {
	/**
	 * 856. 括号的分数
	 * https://leetcode-cn.com/problems/score-of-parentheses/
	 */
	public int scoreOfParentheses(String S) {
		int sum = 0;
		int n = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				if (n == 0) {
					n = 1;
				} else {
					n = n << 1;
				}
			} else if (S.charAt(i) == ')') {
				if (S.charAt(i - 1) == '(') {
					sum += n;
				}
				n = n >> 1;

			}
		}
		return sum;
	}
}
