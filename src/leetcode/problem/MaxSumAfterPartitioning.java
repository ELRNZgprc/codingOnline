package leetcode.problem;

/**
 * 1043. 分隔数组以得到最大和
 * https://leetcode.cn/problems/partition-array-for-maximum-sum/
 */
public class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = -1;
            for (int j = i - 1; j >= Math.max(i - k, 0); j--) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + max * (i - j));
            }
        }
        return dp[n];
    }
}
