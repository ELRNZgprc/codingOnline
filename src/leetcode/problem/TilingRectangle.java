package leetcode.problem;

/**
 * 1240. 铺瓷砖
 * https://leetcode.cn/problems/tiling-a-rectangle-with-the-fewest-squares/
 */
public class TilingRectangle {
    int inf = Integer.MAX_VALUE;
    int[][] dp;

    public int tilingRectangle(int n, int m) {
        dp = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                dp[i][j] = inf;
            }
        }
        return dfs(n, m);

    }

    public int dfs(int n, int m) {
        if (n == m) {
            dp[n][m] = 1;
            return 1;
        }
        if (dp[n][m] != inf) {
            return dp[n][m];
        }
        for (int i = 1; i < n; i++) {
            dp[n][m] = Math.min(dp[n][m], dfs(i, m) + dfs(n - i, m));
        }
        for (int i = 1; i < m; i++) {
            dp[n][m] = Math.min(dp[n][m], dfs(n, i) + dfs(n, m - i));
        }
        for (int x1 = 2; x1 < n; x1++)
            for (int x2 = 1; x2 < x1; x2++)
                for (int y1 = 2; y1 < m; y1++)
                    for (int y2 = 1; y2 < y1; y2++)
                        dp[n][m] = Math.min(dp[n][m], dfs(x2, y1) + dfs(n - x2, y2) + dfs(n - x1, m - y2) + dfs(x1, m - y1) + dfs(x1 - x2, y1 - y2));
        return dp[n][m];
    }
}
