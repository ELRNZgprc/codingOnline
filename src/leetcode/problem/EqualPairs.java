package leetcode.problem;

import java.util.Arrays;

/**
 * 2352. 相等行列对
 * https://leetcode.cn/problems/equal-row-and-column-pairs/
 */
public class EqualPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] grid2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid2[i][j] = grid[j][i];
            }
        }

        int ans = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (Arrays.equals(ints, grid2[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
