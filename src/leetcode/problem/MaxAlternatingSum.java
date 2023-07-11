package leetcode.problem;

/**
 * 1911. 最大子序列交替和
 * https://leetcode.cn/problems/maximum-alternating-subsequence-sum/
 */
public class MaxAlternatingSum {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(Math.max(nums[i], dp[i - 1] - nums[i - 1] + nums[i]), dp[i - 1]);
        }
        return dp[n - 1];
    }
}
