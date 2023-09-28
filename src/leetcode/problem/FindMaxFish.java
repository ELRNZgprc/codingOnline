package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2658. 网格图中鱼的最大数目
 * https://leetcode.cn/problems/maximum-number-of-fish-in-a-grid/
 */
public class FindMaxFish {
    public int findMaxFish(int[][] grid) {
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    queue.add(new int[]{i, j});
                    int fish = 0;
                    while (!queue.isEmpty()) {
                        int[] position = queue.poll();
                        int x = position[0];
                        int y = position[1];
                        fish += grid[x][y];
                        grid[x][y] = 0;
                        for (int[] direction : directions) {
                            int xx = x + direction[0];
                            int yy = y + direction[1];
                            if ((xx > -1) && (xx < n) && (yy > -1) && (yy < m)) {
                                if (grid[xx][yy] > 0) {
                                    queue.add(new int[]{xx, yy});
                                }
                            }
                        }
                    }
                    res = Math.max(res, fish);
                }
            }
        }
        return res;
    }
}
