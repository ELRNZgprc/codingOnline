package leetcode.problem;

/**
 * 2466. 统计构造好字符串的方案数
 * https://leetcode.cn/problems/count-ways-to-build-good-strings/
 */
public class CountGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int mod = 1000000007;
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) {
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            }
            if (i - one >= 0) {
                dp[i] = (dp[i] + dp[i - one]) % mod;
            }
        }
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
}
