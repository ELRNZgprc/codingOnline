package leetcode.problem;

/**
 * 1605. 给定行和列的和求可行矩阵
 * https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/
 */
public class RestoreMatrix {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                if (colSum[j] == 0) {
                    continue;
                }
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
                if (rowSum[i] == 0) {
                    break;
                }
            }
        }
        return ans;
    }
}
