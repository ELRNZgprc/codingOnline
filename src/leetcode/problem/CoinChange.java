package leetcode.problem;

import java.util.Arrays;

public class CoinChange {
    /**
     * 322. 零钱兑换
     * https://leetcode-cn.com/problems/coin-change/
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        if (amount == 0) {
            return 0;
        }
        if (amount < coins[0]) {
            return -1;
        }
        dp[0] = 0;
        for (int i = 1; i < coins[0]; i++) {
            dp[i] = -1;
        }
        dp[coins[0]] = 1;
        for (int i = coins[0] + 1; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if ((i - coin >= 0) && (dp[i - coin] != -1)) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }
}
