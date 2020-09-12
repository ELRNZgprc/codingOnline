package leetcode.problem;

public class NumOfSubarrays {
    /**
     * 1524. 和为奇数的子数组数目
     * https://leetcode-cn.com/problems/number-of-sub-arrays-with-odd-sum/
     */
    public int numOfSubarrays(int[] arr) {
        int[][] dp = new int[arr.length][2];
        dp[0][arr[0] % 2]++;
        int ans = dp[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][1];
            } else {
                dp[i][1] = dp[i - 1][1];
                dp[i][0] = dp[i - 1][0] + 1;
            }
            ans = (ans + dp[i][1]) % 1000000007;
        }
        return ans;
    }
}
