package leetcode.problem;

public class LengthOfLIS {
	/**
	 * 300. 最长上升子序列
	 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
	 */
	public int lengthOfLIS(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int ans = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(dp[i], ans);
		}
		return ans;
	}
}
