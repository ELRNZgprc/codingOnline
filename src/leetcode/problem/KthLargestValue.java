package leetcode.problem;

import java.util.Arrays;

/**
 * 1738. 找出第 K 大的异或坐标值
 * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 */
public class KthLargestValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] temp = new int[n + 1][m + 1];

        int[] ans = new int[n * m];
        int flag = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                temp[i][j] = temp[i - 1][j] ^ temp[i][j - 1] ^ temp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                ans[flag] = temp[i][j];
                flag++;
            }
        }

        Arrays.sort(ans);

        return ans[flag - k];
    }
}
