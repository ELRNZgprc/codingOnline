package leetcode.problem;

/**
 * 1074. 元素和为目标值的子矩阵数量
 * https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/
 */
public class NumSubmatrixSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] sum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int x = 0; x < i; x++) {
                    for (int y = 0; y < j; y++) {
                        if (sum[i][j] + sum[x][y] - sum[i][y] - sum[x][j] == target) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
