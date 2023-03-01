package leetcode.problem;

/**
 * 2373. 矩阵中的局部最大值
 * https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 */
public class LargestLocal {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n - 2][m - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                int max = grid[i][j];
                max = Math.max(max, grid[i - 1][j - 1]);
                max = Math.max(max, grid[i - 1][j]);
                max = Math.max(max, grid[i - 1][j + 1]);
                max = Math.max(max, grid[i][j - 1]);
                max = Math.max(max, grid[i][j + 1]);
                max = Math.max(max, grid[i + 1][j - 1]);
                max = Math.max(max, grid[i + 1][j]);
                max = Math.max(max, grid[i + 1][j + 1]);
                res[i - 1][j - 1] = max;
            }
        }
        return res;
    }
}
