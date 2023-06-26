package leetcode.problem;

/**
 * 1975. 最大方阵和
 * https://leetcode.cn/problems/maximum-matrix-sum/
 */
public class MaxMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        boolean isNegative = false;
        long sum = 0;
        int min = Math.abs(matrix[0][0]);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt < 0) {
                    isNegative = !isNegative;
                }
                sum += Math.abs(anInt);
                min = Math.min(min, Math.abs(anInt));
            }
        }
        if (isNegative) {
            sum -= (2L * min);
        }
        return sum;
    }
}
