package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

public class HasValidPath {
	/**
	 * 1391. 检查网格中是否存在有效路径
	 * https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid/
	 */
    public boolean hasValidPath(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        queue.add(0);
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int j = num % m;
            int i = num / m;
            switch (grid[i][j]) {
                case 1:
                    if (j - 1 > -1) {
                        if ((visited[i][j - 1] == 0) && ((grid[i][j - 1] == 1) || (grid[i][j - 1] == 4) || (grid[i][j - 1] == 6))) {
                            visited[i][j - 1] = 1;
                            queue.add(num - 1);
                        }
                    }
                    if (j + 1 < m) {
                        if ((visited[i][j + 1] == 0) && ((grid[i][j + 1] == 1) || (grid[i][j + 1] == 3) || (grid[i][j + 1] == 5))) {
                            visited[i][j + 1] = 1;
                            queue.add(num + 1);
                        }
                    }
                    break;
                case 2:
                    if (i - 1 > -1) {
                        if ((visited[i - 1][j] == 0) && ((grid[i - 1][j] == 2) || (grid[i - 1][j] == 3) || (grid[i - 1][j] == 4))) {
                            visited[i - 1][j] = 1;
                            queue.add(num - m);
                        }
                    }
                    if (i + 1 < n) {
                        if ((visited[i + 1][j] == 0) && ((grid[i + 1][j] == 2) || (grid[i + 1][j] == 5) || (grid[i + 1][j] == 6))) {
                            visited[i + 1][j] = 1;
                            queue.add(num + m);
                        }
                    }
                    break;
                case 3:
                    if (j - 1 > -1) {
                        if ((visited[i][j - 1] == 0) && ((grid[i][j - 1] == 1) || (grid[i][j - 1] == 4) || (grid[i][j - 1] == 6))) {
                            visited[i][j - 1] = 1;
                            queue.add(num - 1);
                        }
                    }
                    if (i + 1 < n) {
                        if ((visited[i + 1][j] == 0) && ((grid[i + 1][j] == 2) || (grid[i + 1][j] == 5) || (grid[i + 1][j] == 6))) {
                            visited[i + 1][j] = 1;
                            queue.add(num + m);
                        }
                    }
                    break;
                case 4:
                    if (j + 1 < m) {
                        if ((visited[i][j + 1] == 0) && ((grid[i][j + 1] == 1) || (grid[i][j + 1] == 3) || (grid[i][j + 1] == 5))) {
                            visited[i][j + 1] = 1;
                            queue.add(num + 1);
                        }
                    }
                    if (i + 1 < n) {
                        if ((visited[i + 1][j] == 0) && ((grid[i + 1][j] == 2) || (grid[i + 1][j] == 5) || (grid[i + 1][j] == 6))) {
                            visited[i + 1][j] = 1;
                            queue.add(num + m);
                        }
                    }
                    break;
                case 5:
                    if (j - 1 > -1) {
                        if ((visited[i][j - 1] == 0) && ((grid[i][j - 1] == 1) || (grid[i][j - 1] == 4) || (grid[i][j - 1] == 6))) {
                            visited[i][j - 1] = 1;
                            queue.add(num - 1);
                        }
                    }
                    if (i - 1 > -1) {
                        if ((visited[i - 1][j] == 0) && ((grid[i - 1][j] == 2) || (grid[i - 1][j] == 3) || (grid[i - 1][j] == 4))) {
                            visited[i - 1][j] = 1;
                            queue.add(num - m);
                        }
                    }
                    break;
                case 6:
                    if (j + 1 < m) {
                        if ((visited[i][j + 1] == 0) && ((grid[i][j + 1] == 1) || (grid[i][j + 1] == 3) || (grid[i][j + 1] == 5))) {
                            visited[i][j + 1] = 1;
                            queue.add(num + 1);
                        }
                    }
                    if (i - 1 > -1) {
                        if ((visited[i - 1][j] == 0) && ((grid[i - 1][j] == 2) || (grid[i - 1][j] == 3) || (grid[i - 1][j] == 4))) {
                            visited[i - 1][j] = 1;
                            queue.add(num - m);
                        }
                    }
                    break;
            }
        }
        return (visited[n - 1][m - 1] == 1);
    }
}
