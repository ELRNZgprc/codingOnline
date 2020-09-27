package leetcode.problem;

public class LastStoneWeightII {
	/**
	 * 1049. 最后一块石头的重量 II
	 * https://leetcode-cn.com/problems/last-stone-weight-ii/
	 */
	public int lastStoneWeightII(int[] stones) {
		int sum = 0;
		for (int i = 0; i < stones.length; i++) {
			sum += stones[i];
		}
		int target = sum / 2;
		int[] dp = new int[target + 1];
		for (int i = 0; i < stones.length; i++) {
			for (int j = target; j >= stones[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
			}
		}
		return Math.abs(sum - 2 * dp[target]);
	}
}
