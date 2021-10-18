package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * https://leetcode-cn.com/problems/rotting-oranges/
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        if ((grid == null) || (grid.length == 0) || (grid[0].length == 0)) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count1 = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j);
                } else if (grid[i][j] == 1) {
                    count1++;
                }
            }
        }
        int time = 0;
        while ((!queue.isEmpty()) && (count1 > 0)) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p = queue.poll();
                int x = p / n;
                int y = p % n;
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    count1--;
                    grid[x - 1][y] = 2;
                    queue.offer((x - 1) * n + y);
                }
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    count1--;
                    grid[x + 1][y] = 2;
                    queue.offer((x + 1) * n + y);
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    count1--;
                    grid[x][y - 1] = 2;
                    queue.offer(x * n + y - 1);
                }
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    count1--;
                    grid[x][y + 1] = 2;
                    queue.offer(x * n + y + 1);
                }
            }
        }
        return count1 == 0 ? time : -1;
    }
}
