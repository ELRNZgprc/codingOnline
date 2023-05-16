package leetcode.problem;

import java.util.Arrays;

/**
 * 1335. 工作计划的最低难度
 * https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/
 */
public class MinDifficulty {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            int u = 0;
            for (int j = i; j < n; j++) {
                u = Math.max(u, jobDifficulty[j]);
                max[i][j] = u;
            }
        }
        int[][] dp = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
            dp[i][1] = max[0][i];
        }
        for (int day = 2; day <= d; day++) {
            for (int j = 1; j < n; j++) {
                for (int i = j - 1; i >= 0; i--) {
                    dp[j][day] = Math.min(dp[j][day], dp[i][day - 1] + max[i + 1][j]);
                }
            }
        }
        return dp[n - 1][d];
    }
}
