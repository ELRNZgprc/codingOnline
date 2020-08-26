package leetcode.problem;

public class CountBits {
    /**
     * 338. 比特位计数
     * https://leetcode-cn.com/problems/counting-bits/
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 0; i <= num / 2; i++) {
            dp[i * 2] = dp[i];
            if (i * 2 + 1 <= num) {
                dp[i * 2 + 1] = dp[i] + 1;
            }
        }
        return dp;
    }
}
