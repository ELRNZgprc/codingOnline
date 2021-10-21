package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1926. 迷宫中离入口最近的出口
 * https://leetcode-cn.com/problems/nearest-exit-from-entrance-in-maze/
 */
public class NearestExit {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.add(entrance[0] * n + entrance[1]);
        maze[entrance[0]][entrance[1]] = '+';
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int pos = q.poll();
                int y = pos % n;
                int x = pos / n;
                if ((x - 1 > -1) && (maze[x - 1][y] == '.')) {
                    q.add((x - 1) * n + y);
                    maze[x - 1][y] = '+';
                    if ((x - 1 == 0) || (y == 0) || (y == n - 1)) {
                        return ans;
                    }
                }
                if ((x + 1 < m) && (maze[x + 1][y] == '.')) {
                    q.add((x + 1) * n + y);
                    maze[x + 1][y] = '+';
                    if ((x + 1 == m - 1) || (y == 0) || (y == n - 1)) {
                        return ans;
                    }
                }
                if ((y - 1 > -1) && (maze[x][y - 1] == '.')) {
                    q.add(x * n + y - 1);
                    maze[x][y - 1] = '+';
                    if ((x == 0) || (x == m - 1) || (y - 1 == 0)) {
                        return ans;
                    }
                }
                if ((y + 1 < n) && (maze[x][y + 1] == '.')) {
                    q.add(x * n + y + 1);
                    maze[x][y + 1] = '+';
                    if ((x == 0) || (x == m - 1) || (y + 1 == n - 1)) {
                        return ans;
                    }
                }
            }
        }
        return -1;
    }
}
