package leetcode.problem;

import java.util.List;

public class PathsWithMaxScore {
    /**
     * 1301. 最大得分的路径数目
     * https://leetcode-cn.com/problems/number-of-paths-with-max-score/
     */
    public int[] pathsWithMaxScore(List<String> board) {
        int[][] directions = {{1, 0}, {0, 1}, {1, 1}};
        int n = board.size();
        int[][][] record = new int[n][n][2];
        record[n - 1][n - 1][0] = 0;
        record[n - 1][n - 1][1] = 1;
        for (int i = n - 2; i > -1; i--) {
            if ((board.get(i).charAt(n - 1) == 'X') || ((record[i + 1][n - 1][0] == 0) && ((record[i + 1][n - 1][1] == 0)))) {
                record[i][n - 1][0] = 0;
                record[i][n - 1][1] = 0;
            } else {
                record[i][n - 1][0] = record[i + 1][n - 1][0] + board.get(i).charAt(n - 1) - '0';
                record[i][n - 1][1] = record[i + 1][n - 1][1];
            }
        }
        for (int j = n - 2; j > -1; j--) {
            if ((board.get(n - 1).charAt(j) == 'X') || ((record[n - 1][j + 1][0] == 0) && ((record[n - 1][j + 1][1] == 0)))) {
                record[n - 1][j][0] = 0;
                record[n - 1][j][1] = 0;
            } else {
                record[n - 1][j][0] = record[n - 1][j + 1][0] + board.get(n - 1).charAt(j) - '0';
                record[n - 1][j][1] = record[n - 1][j + 1][1];
            }
        }
        for (int i = n - 2; i > -1; i--) {
            for (int j = n - 2; j > -1; j--) {
                record[i][j][0] = 0;
                record[i][j][1] = 0;
                if (board.get(i).charAt(j) != 'X') {
                    record[i][j][0] = 0;
                    record[i][j][1] = 0;
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (record[x][y][0] > record[i][j][0]) {
                            record[i][j][0] = record[x][y][0];
                            record[i][j][1] = record[x][y][1];
                        } else if (record[x][y][0] == record[i][j][0]) {
                            record[i][j][1] += record[x][y][1];
                            record[i][j][1] %= 1000000007;
                        }
                    }
                    if (record[i][j][1] != 0) {
                        if (board.get(i).charAt(j) != 'E') {
                            record[i][j][0] += board.get(i).charAt(j) - '0';
                        }
                    }
                }
            }
        }
        return new int[]{record[0][0][0], record[0][0][1]};
    }
}
