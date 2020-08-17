package leetcode.mst;

public class setZeroes {
    /**
     * 面试题 01.08
     * https://leetcode-cn.com/problems/zero-matrix-lcci/
     */
    public void setZeroes(int[][] matrix) {
        boolean[] m = new boolean[matrix.length];
        boolean[] n = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            m[i] = false;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            n[j] = false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    m[i] = true;
                    n[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (m[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (n[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
