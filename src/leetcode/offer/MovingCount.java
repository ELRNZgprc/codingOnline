package leetcode.offer;

public class MovingCount {
    /**
     * 剑指 Offer 13. 机器人的运动范围
     * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, k, visited, 0, 0);
    }

    int dfs(int m, int n, int k, boolean[][] visited, int x, int y) {
        if ((x < 0) || (x > m - 1) || (y < 0) || (y > n - 1) || (visited[x][y]) || (x % 10 + x / 10 + y % 10 + y / 10 > k)) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(m, n, k, visited, x - 1, y) + dfs(m, n, k, visited, x + 1, y) + dfs(m, n, k, visited, x, y - 1) + dfs(m, n, k, visited, x, y + 1);
    }
}
