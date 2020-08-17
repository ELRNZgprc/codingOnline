package leetcode.problem;

public class solveSudoku {
    /**
     * 37
     * https://leetcode-cn.com/problems/sudoku-solver/
     */
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                row[i][j] = true;
                col[i][j] = true;
                block[i][j] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = false;
                    col[j][num] = false;
                    block[i / 3 * 3 + j / 3][num] = false;
                }
            }
        }
        work(board, row, col, block, 0, 0);
    }

    private boolean work(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int n, int m) {
        while (board[n][m] != '.') {
            m++;
            if (m >= 9) {
                m = 0;
                n++;
            }
            if (n >= 9) {
                return true;
            }
        }
        int blockNumber = n / 3 * 3 + m / 3;
        for (int num = 1; num <= 9; num++) {
            if (row[n][num - 1] && col[m][num - 1] && block[blockNumber][num - 1]) {
                board[n][m] = (char) (num + '0');
                row[n][num - 1] = false;
                col[m][num - 1] = false;
                block[blockNumber][num - 1] = false;
                if (work(board, row, col, block, n, m)) {
                    return true;
                } else {
                    board[n][m] = '.';
                    row[n][num - 1] = true;
                    col[m][num - 1] = true;
                    block[blockNumber][num - 1] = true;
                }
            }
        }
        return false;
    }
}
