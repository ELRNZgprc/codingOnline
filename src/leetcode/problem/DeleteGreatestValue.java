package leetcode.problem;

import java.util.Arrays;

/**
 * 2500. 删除每行中的最大值
 * https://leetcode.cn/problems/delete-greatest-value-in-each-row/submissions/
 */
public class DeleteGreatestValue {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] l : grid) {
            Arrays.sort(l);
        }
        int ans = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }
        return ans;
    }
}
