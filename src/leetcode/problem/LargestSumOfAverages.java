package leetcode.problem;

/**
 * 813. 最大平均值和的分组
 * https://leetcode-cn.com/problems/largest-sum-of-averages/
 */
public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[nums.length + 1][k + 1];
        double[] sum = new double[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            dp[i][1] = sum[i] / i;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int length = 2; length <= k; length++) {
                for (int j = 0; j < i; j++) {
                    dp[i][length] = Math.max(dp[i][length], dp[j][length - 1] + (sum[i] - sum[j]) / (i - j));
                }
            }
        }
        return dp[nums.length][k];
    }
}
