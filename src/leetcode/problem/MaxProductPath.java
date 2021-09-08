package leetcode.problem;

/**
 * 1594. 矩阵的最大非负积
 * https://leetcode-cn.com/problems/maximum-non-negative-product-in-a-matrix/
 */
public class MaxProductPath {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][][] dp = new long[n][m][2];
        dp[0][0][0] = dp[0][0][1] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = dp[i][0][1] = dp[i - 1][0][0] * grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i][0] = dp[0][i][1] = dp[0][i - 1][0] * grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] >= 0) {
                    dp[i][j][0] = Math.min(dp[i][j - 1][0], dp[i - 1][j][0]) * grid[i][j];
                    dp[i][j][1] = Math.max(dp[i][j - 1][1], dp[i - 1][j][1]) * grid[i][j];
                } else {
                    dp[i][j][1] = Math.min(dp[i][j - 1][0], dp[i - 1][j][0]) * grid[i][j];
                    dp[i][j][0] = Math.max(dp[i][j - 1][1], dp[i - 1][j][1]) * grid[i][j];
                }
            }
        }
        if (dp[n - 1][m - 1][1] < 0) {
            return -1;
        }
        return (int) (dp[n - 1][m - 1][1] % 1000000007);
    }
}
