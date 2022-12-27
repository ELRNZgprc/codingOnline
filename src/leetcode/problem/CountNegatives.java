package leetcode.problem;

/**
 * 1351. 统计有序矩阵中的负数
 * https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class CountNegatives {
    public int countNegatives(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] < 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
