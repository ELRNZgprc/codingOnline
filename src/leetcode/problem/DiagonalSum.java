package leetcode.problem;

/**
 * 1572. 矩阵对角线元素的和
 * https://leetcode.cn/problems/matrix-diagonal-sum/
 */
public class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, ans = 0;
        for (int i = 0; i < n; i++) {
            ans += mat[i][i] + mat[i][n - 1 - i];
        }
        if ((n & 1) == 1) {
            ans -= mat[n >> 1][n >> 1];
        }
        return ans;
    }
}
