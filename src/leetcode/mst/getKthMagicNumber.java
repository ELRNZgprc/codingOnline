package leetcode.mst;

public class getKthMagicNumber {
    /**
     * 面试题 17.09
     * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
     */
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int num3 = 0;
        int num5 = 0;
        int num7 = 0;

        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(dp[num3] * 3, dp[num5] * 5);
            dp[i] = Math.min(dp[i], dp[num7] * 7);
            if (dp[i] % 3 == 0) {
                num3++;
            }
            if (dp[i] % 5 == 0) {
                num5++;
            }
            if (dp[i] % 7 == 0) {
                num7++;
            }
        }
        return dp[k - 1];
    }
}
