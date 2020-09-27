package leetcode.problem;

public class MaxA {
    /**
     * 651. 4键键盘
     * https://leetcode-cn.com/problems/4-keys-keyboard/
     */
    public int maxA(int N) {
        if (N <= 3) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[N];
    }
}
