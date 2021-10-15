package leetcode.problem;

/**
 * 1746. 经过一次操作后的最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray-sum-after-one-operation/
 */
public class MaxSumAfterOperation {
    public int maxSumAfterOperation(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];
        int ans = dp[0][1];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(0, dp[i - 1][0] + nums[i]);
            dp[i][1] = Math.max(0, Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0] + nums[i] * nums[i]));
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}
