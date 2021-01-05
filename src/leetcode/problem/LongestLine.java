package leetcode.problem;

public class LongestLine {
	/**
	 * 562. 矩阵中最长的连续1线段
	 * https://leetcode-cn.com/problems/longest-line-of-consecutive-one-in-matrix/
	 */
	public int longestLine(int[][] M) {
		if (M.length == 0 || M[0].length == 0) {
			return 0;
		}
		int maxlength = 0;
		int[][][] dp = new int[M.length][M[0].length][4];
		for (int i = 0; i < M.length; i += 1) {
			for (int k = 0; k < M[0].length; k += 1) {
				if (M[i][k] == 1) {
					dp[i][k][0] = (k - 1 >= 0) ? dp[i][k - 1][0] + 1 : 1;
					dp[i][k][1] = (i - 1 >= 0) ? dp[i - 1][k][1] + 1 : 1;
					dp[i][k][2] = (i - 1 >= 0 && k - 1 >= 0) ? dp[i - 1][k - 1][2] + 1 : 1;
					dp[i][k][3] = (i - 1 >= 0 && k + 1 < M[0].length) ? dp[i - 1][k + 1][3] + 1 : 1;
					maxlength = Math.max(maxlength,
							Math.max(dp[i][k][0], Math.max(dp[i][k][1], Math.max(dp[i][k][2], dp[i][k][3]))));
				}
			}
		}
		return maxlength;
	}
}
