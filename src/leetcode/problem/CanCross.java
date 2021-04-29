package leetcode.problem;

/**
 * 403. 青蛙过河
 * https://leetcode-cn.com/problems/frog-jump/
 */
public class CanCross {
    public boolean canCross(int[] stones) {
        boolean[][] dp = new boolean[stones.length][stones.length + 1];
        dp[0][1] = true;
        for (int i = 1; i < stones.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int distance = stones[i] - stones[j];
                if (distance <= i) {
                    if (dp[j][distance]) {
                        dp[i][distance] = true;
                        dp[i][distance - 1] = true;
                        if (distance + 1 < dp[j].length) {
                            dp[i][distance + 1] = true;
                        }
                    }
                }
            }
        }
        boolean ans = false;
        for (boolean b : dp[stones.length - 1]) {
            ans = ans || b;
        }
        return ans;
    }
}
