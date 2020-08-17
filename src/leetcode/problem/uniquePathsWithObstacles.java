package leetcode.problem;

public class uniquePathsWithObstacles {
    /**
     * 63
     * https://leetcode-cn.com/problems/unique-paths-ii/
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            dp[j] = (obstacleGrid[0][j] == 1) ? 0 : dp[j - 1];
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            dp[0] = (obstacleGrid[i][0] == 1) ? 0 : dp[0];
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[j] = (obstacleGrid[i][j] == 1) ? 0 : dp[j - 1] + dp[j];
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
