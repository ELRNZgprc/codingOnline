package leetcode.problem;

public class generateMatrix {
    /**
     * 59
     * https://leetcode-cn.com/problems/spiral-matrix-ii/
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i < n * n; i++) {
            ans[x][y] = i;
            while (!((x + directions[dir][0] < n) && (x + directions[dir][0] >= 0) && (y + directions[dir][1] < n) && (y + directions[dir][1] >= 0) && (ans[x + directions[dir][0]][y + directions[dir][1]] == 0))) {
                dir = (dir + 1) % 4;
            }
            x += directions[dir][0];
            y += directions[dir][1];
        }
        ans[x][y] = n * n;
        return ans;
    }
}
