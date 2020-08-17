package leetcode.offer;

public class twoSum {
    /**
     * offer 60
     * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
     */
    public double[] twoSum(int n) {
        double[] ans = new double[5 * n + 1];

        int[][] sum = new int[n + 1][6 * n + 1];
        int i, j;

        for (j = 1; j <= 6; j++)
            sum[1][j] = 1;

        for (i = 2; i <= n; i++) {
            for (j = i; j <= 6 * i; j++) {
                int left = ((j - 6) > (i - 1)) ? j - 6 : i - 1;
                int right = ((j - 1) > (6 * i - 6)) ? 6 * i - 6 : j - 1;
                sum[i][j] = 0;
                for (int k = left; k <= right; k++) {
                    sum[i][j] += sum[i - 1][k] * sum[1][j - k];
                }
            }
        }

        int total = 0;
        for (j = n; j <= 6 * n; j++) {
            total += sum[n][j];
        }

        for (j = n; j <= 6 * n; j++) {
            ans[j - n] = ((double) sum[n][j]) / total;
        }

        return ans;
    }
}
