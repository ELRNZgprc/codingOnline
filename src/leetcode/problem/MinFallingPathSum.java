package leetcode.problem;

public class MinFallingPathSum {
	/**
	 * 931. 下降路径最小和
	 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
	 */
	public int minFallingPathSum(int[][] A) {
		int length = A.length;
		for (int i = 1; i < length; i++) {
			A[i][0] += Math.min(A[i - 1][0], A[i - 1][1]);
			for (int j = 1; j < length - 1; j++) {
				A[i][j] += Math.min(A[i - 1][j + 1], Math.min(A[i - 1][j - 1], A[i - 1][j]));
			}
			A[i][length - 1] += Math.min(A[i - 1][length - 1], A[i - 1][length - 2]);
		}
		int ans = A[length - 1][0];
		for (int j = 1; j < length; j++) {
			ans = Math.min(ans, A[length - 1][j]);
		}
		return ans;
	}
}
