package leetcode.problem;

public class maxSumDivThree {
    /**
     * 1262
     * https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
     */
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int i : nums) {
            int[] dp0 = new int[3];
            for (int j = 0; j < 3; j++) {
                dp0[j] = dp[j];
            }
            for (int j : dp0) {
                switch ((j + i) % 3) {
                    case 0:
                        dp[0] = Math.max(dp[0], i + j);
                        break;
                    case 1:
                        dp[1] = Math.max(dp[1], i + j);
                        break;
                    case 2:
                        dp[2] = Math.max(dp[2], i + j);
                        break;
                }
            }
        }
        return dp[0];
    }
}
