package leetcode.problem;

/**
 * 1269. 停在原地的方案数
 * https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 */
public class NumWays1269 {
    public int numWays(int steps, int arrLen) {
        int n = Math.min(arrLen - 1, steps >> 1);
        int[][] dp = new int[steps + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000007;
                }
                if (j < n) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % 1000000007;
                }
            }
        }
        return dp[steps][0];
    }
}
