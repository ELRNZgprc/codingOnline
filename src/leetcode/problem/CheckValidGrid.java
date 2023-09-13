package leetcode.problem;

/**
 * 2596. 检查骑士巡视方案
 * https://leetcode.cn/problems/check-knight-tour-configuration/
 */
public class CheckValidGrid {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int len = grid.length;
        int[][] record = new int[len * len][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                record[grid[i][j]] = new int[]{i, j};
            }
        }
        for (int i = 1; i < len * len; i++) {
            int x = Math.abs(record[i][0] - record[i - 1][0]);
            int y = Math.abs(record[i][1] - record[i - 1][1]);
            if (!(((x == 1) && (y == 2)) || ((x == 2) && (y == 1)))) {
                return false;
            }
        }
        return true;
    }
}
