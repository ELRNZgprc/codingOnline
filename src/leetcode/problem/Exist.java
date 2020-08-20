package leetcode.problem;

public class Exist {
    /**
     * 79. 单词搜索
     * https://leetcode-cn.com/problems/word-search/
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    boolean search(char[][] board, String word, int i, int j, int k) {
        if (k >= word.length()) {
            return true;
        }
        if ((i < 0) || (i >= board.length) || (j < 0) || (j >= board[0].length)) {
            return false;
        }
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        board[i][j] += 132;
        boolean result = false;
        for (int[] dire : directions) {
            result = result || search(board, word, i + dire[0], j + dire[1], k + 1);
        }
        board[i][j] -= 132;
        return result;
    }
}
