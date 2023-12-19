package leetcode.problem;

/**
 * 1901. 寻找峰值 II
 * https://leetcode.cn/problems/find-a-peak-element-ii/
 */
public class FindPeakGrid {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = l + r >> 1;
            int max = 0, k = 0;
            for (int i = 0; i < n; i++) {
                if (mat[mid][i] > max) {
                    max = mat[mid][i];
                    k = i;
                }
            }
            if (mat[mid][k] < mat[mid + 1][k]) l = mid + 1;
            else r = mid;
        }
        int max = 0, k = 0;
        for (int i = 0; i < n; i++) {
            if (mat[l][i] > max) {
                max = mat[l][i];
                k = i;
            }
        }
        return new int[]{l, k};
    }
}
