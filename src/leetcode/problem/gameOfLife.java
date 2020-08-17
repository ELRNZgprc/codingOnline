package leetcode.problem;

public class gameOfLife {
    /**
     * 289
     * https://leetcode-cn.com/problems/game-of-life/
     */
    public void gameOfLife(int[][] board) {
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int n = board.length;
        int m = board[0].length;
        int[][] partner = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    if ((i + directions[k][0] >= 0) && (i + directions[k][0] < n) && (j + directions[k][1] >= 0) && (j + directions[k][1] < m)) {
                        partner[i][j] += board[i + directions[k][0]][j + directions[k][1]];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    if (partner[i][j] == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    if ((partner[i][j] < 2) || (partner[i][j] > 3)) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
}
