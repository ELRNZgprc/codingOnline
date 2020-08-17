package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

public class solve {
    /**
     * 130
     * https://leetcode-cn.com/problems/surrounded-regions/
     */
    public void solve(char[][] board) {
        int n = board.length;
        if (n <= 2) {
            return;
        }
        int m = board[0].length;
        if (m <= 2) {
            return;
        }

        int[][] dest = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int[][] target = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                int[] node = {i, 0};
                target[i][0] = 1;
                queue.add(node);
            }
            if (board[i][m - 1] == 'O') {
                int[] node = {i, m - 1};
                target[i][m - 1] = 1;
                queue.add(node);
            }
        }
        for (int j = 1; j < m - 1; j++) {
            if (board[0][j] == 'O') {
                int[] node = {0, j};
                target[0][j] = 1;
                queue.add(node);
            }
            if (board[n - 1][j] == 'O') {
                int[] node = {n - 1, j};
                target[n - 1][j] = 1;
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            int[] node1 = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node1[0] + dest[i][0];
                int y = node1[1] + dest[i][1];
                if ((x > -1) && (x < n) && (y > -1) && (y < m)) {
                    if ((board[x][y] == 'O') && (target[x][y] != 1)) {
                        int[] node = {x, y};
                        target[x][y] = 1;
                        queue.add(node);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((board[i][j] == 'O') && (target[i][j] != 1)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
