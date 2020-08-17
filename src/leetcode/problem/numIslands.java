package leetcode.problem;

public class numIslands {
    /**
     * 200
     * https://leetcode-cn.com/problems/number-of-islands/
     */
    public int numIslands(char[][] grid) {
        if ((grid.length < 1) || (grid[0].length < 1)) {
            return 0;
        }
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    work200(grid, i, j);
                }
            }
        }
        return ans;
    }

    void work200(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        work200(grid, i + 1, j);
        work200(grid, i - 1, j);
        work200(grid, i, j + 1);
        work200(grid, i, j - 1);
    }
}
