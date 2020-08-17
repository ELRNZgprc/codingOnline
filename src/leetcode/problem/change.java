package leetcode.problem;

public class change {
    /**
     * 518
     * https://leetcode-cn.com/problems/coin-change-2/
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < amount + 1; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
