package leetcode.problem;

public class ProbabilityOfHeads {
	/**
	 * 1230. 抛掷硬币
	 * https://leetcode-cn.com/problems/toss-strange-coins/
	 */
	public double probabilityOfHeads(double[] prob, int target) {
		int size = prob.length;
		double[][] dp = new double[size + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= size; i++) {
			dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
		}
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= target; j++) {
				dp[i][j] = dp[i - 1][j - 1] * prob[i - 1] + dp[i - 1][j] * (1 - prob[i - 1]);
			}
		}
		return dp[size][target];
	}
}
