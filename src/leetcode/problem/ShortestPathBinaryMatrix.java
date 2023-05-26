package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 * https://leetcode.cn/problems/shortest-path-in-binary-matrix/
 */
public class ShortestPathBinaryMatrix {
    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        while (!q.isEmpty()) {
            int[] a = q.poll();
            for (int[] m : move) {
                int x = a[0] + m[0], y = a[1] + m[1];
                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                    grid[x][y] = 1;
                    if (x == n - 1 && y == n - 1) {
                        return a[2] + 1;
                    }
                    q.add(new int[]{x, y, a[2] + 1});
                }
            }
        }
        return -1;
    }
}
