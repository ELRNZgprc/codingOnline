package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateBoard {
    /**
     * 529. 扫雷游戏
     * https://leetcode-cn.com/problems/minesweeper/
     */
    public int[][] dire = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, 0}, {1, 1}, {1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[m + 1][n + 1];
        queue.add(click);
        vis[click[0]][click[1]] = true;
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int x = cur[0], y = cur[1];
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
                return board;
            }
            int count = helper(board, x, y);

            if (count != 0) {
                board[x][y] = (char) (count + '0');
                continue;
            }
            board[x][y] = 'B';
            for (int d[] : dire) {
                int a = d[0] + x, b = d[1] + y;
                if (a < 0 || a >= m || b < 0 || b >= n || vis[a][b]) continue;
                vis[a][b] = true;
                queue.add(new int[]{a, b});
            }
        }
        return board;

    }

    public int helper(char[][] board, int x, int y) {
        int count = 0;
        for (int d[] : dire) {
            int a = x + d[0], b = y + d[1];
            if (a < 0 || a >= board.length || b < 0 || b >= board[0].length) continue;
            if (board[a][b] == 'M') count += 1;
        }
        return count;
    }
}
