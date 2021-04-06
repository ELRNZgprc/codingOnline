package leetcode.problem;

/**
 * 518. 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 */
public class Change {
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
