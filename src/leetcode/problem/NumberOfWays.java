package leetcode.problem;

public class NumberOfWays {
	/**
	 * 1259. 不相交的握手
	 * https://leetcode-cn.com/problems/handshakes-that-dont-cross/
	 */
	public int numberOfWays(int num_people) {
		int length = num_people / 2;
		long[] dp = new long[length + 1];
		dp[0] = 1;
		for (int i = 1; i <= length; i++) {
			int j = 0;
			int k = i - 1;
			while (j <= k) {
				dp[i] = (dp[i] + dp[j] * dp[k]) % 1000000007;
				if (j != k) {
					dp[i] = (dp[i] + dp[j] * dp[k]) % 1000000007;
				}
				j++;
				k--;
			}
		}
		return (int) dp[length];
	}
}
