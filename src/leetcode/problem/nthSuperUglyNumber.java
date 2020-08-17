package leetcode.problem;

public class nthSuperUglyNumber {
    /**
     * 313
     * https://leetcode-cn.com/problems/super-ugly-number/
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] nums = new int[primes.length];

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[nums[j]] * primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] % primes[j] == 0) {
                    nums[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
