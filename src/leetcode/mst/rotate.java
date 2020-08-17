package leetcode.mst;

public class rotate {
    /**
     * 面试题 01.07
     * https://leetcode-cn.com/problems/rotate-matrix-lcci/
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] newMatrix = new int[length + 1][length + 1];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                newMatrix[j][length - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }
}
