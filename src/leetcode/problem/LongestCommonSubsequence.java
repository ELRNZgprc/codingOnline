package leetcode.problem;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < 1) {
            return 0;
        }
        if (text2.length() < 1) {
            return 0;
        }

        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];


        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }
        for (int j = 1; j < m; j++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < n; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
            for (int j = 1; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
