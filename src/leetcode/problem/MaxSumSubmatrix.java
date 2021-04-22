package leetcode.problem;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class MaxSumSubmatrix {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int s[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] + matrix[i - 1][j - 1] - s[i - 1][j - 1];
            }
        }
        long res = (long) -1e18;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int a = i + 1; a <= m; a++) {
                    for (int b = j + 1; b <= n; b++) {
                        long sum = s[a][b] + s[i][j] - s[a][j] - s[i][b];
                        if (sum <= k) res = Math.max(res, sum);
                    }
                }
            }
        }
        return (int) res;
    }
}
