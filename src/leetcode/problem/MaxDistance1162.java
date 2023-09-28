package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. 地图分析
 * https://leetcode.cn/problems/as-far-from-land-as-possible/
 */
public class MaxDistance1162 {
    public int maxDistance(int[][] grid) {
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int res = 0;

        Queue<int[]> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            for (int[] direction : directions) {
                int xx = x + direction[0];
                int yy = y + direction[1];
                if ((xx > -1) && (xx < n) && (yy > -1) && (yy < m)) {
                    if (grid[xx][yy] == 0) {
                        grid[xx][yy] = 1;
                        next.add(new int[]{xx, yy});
                    }
                }
            }
            if (queue.isEmpty()) {
                queue.addAll(next);
                if (!queue.isEmpty()) {
                    res++;
                }
                next = new LinkedList<>();
            }
        }
        return res == 0 ? -1 : res;
    }

}
