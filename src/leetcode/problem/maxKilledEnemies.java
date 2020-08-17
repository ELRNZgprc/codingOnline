package leetcode.problem;

public class maxKilledEnemies {
    /**
     * 361
     * https://leetcode-cn.com/problems/bomb-enemy/
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] es = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'E') {
                    int ii = i - 1;
                    while ((ii >= 0) && (grid[ii][j] != 'W')) {
                        if (grid[ii][j] == '0') {
                            es[ii][j]++;
                        }
                        ii--;
                    }
                    ii = i + 1;
                    while ((ii < n) && (grid[ii][j] != 'W')) {
                        if (grid[ii][j] == '0') {
                            es[ii][j]++;
                        }
                        ii++;
                    }
                    int jj = j - 1;
                    while ((jj >= 0) && (grid[i][jj] != 'W')) {
                        if (grid[i][jj] == '0') {
                            es[i][jj]++;
                        }
                        jj--;
                    }
                    jj = j + 1;
                    while ((jj < m) && (grid[i][jj] != 'W')) {
                        if (grid[i][jj] == '0') {
                            es[i][jj]++;
                        }
                        jj++;
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, es[i][j]);
            }
        }
        return ans;
    }
}
