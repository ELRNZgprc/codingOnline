package leetcode.problem;

/**
 * 1139. 最大的以 1 为边界的正方形
 * https://leetcode.cn/problems/largest-1-bordered-square/
 */
public class Largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][2];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 0) continue;
                dp[i][j][0] = dp[i - 1][j][0] + 1;
                dp[i][j][1] = dp[i][j - 1][1] + 1;
                int min = Math.min(dp[i][j][0], dp[i][j][1]);
                for (int k = 0; k < min; k++) {
                    if (dp[i - k][j][1] >= k + 1 && dp[i][j - k][0] >= k + 1) {
                        ans = Math.max(ans, k + 1);
                    }
                }
            }
        }
        return ans * ans;
    }
}
