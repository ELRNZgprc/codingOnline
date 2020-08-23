package leetcode.problem;

public class SetZeroes {
    /**
     * 73. 矩阵置零
     * https://leetcode-cn.com/problems/set-matrix-zeroes/
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] flagX = new boolean[n];
        boolean[] flagY = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    flagX[i] = true;
                    flagY[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (flagX[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            if (flagY[j]) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
