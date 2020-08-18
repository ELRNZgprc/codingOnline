package leetcode.problem;

public class LongestPrefix {
    /**
     * 1392
     * https://leetcode-cn.com/problems/longest-happy-prefix/
     */
    public String longestPrefix(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int[] dp = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j != 0 && chs[j] != chs[i]) {
                j = dp[j - 1];
            }
            if (chs[j] == chs[i]) {
                dp[i] = ++j;
            }
        }
        return s.substring(0, dp[n - 1]);
    }
}
