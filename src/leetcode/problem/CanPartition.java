package leetcode.problem;

public class CanPartition {
	/**
	 * 416. 分割等和子集
	 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
	 */
	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 == 1)
			return false;
		sum /= 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		int curSum = 0;
		for (int num : nums) {
			curSum += num;
			curSum = Math.min(curSum, sum);
			for (int j = curSum; j >= num; j--) {
				dp[j] = dp[j] || dp[j - num];
			}
			if (dp[sum])
				return true;
		}
		return false;
	}
}
