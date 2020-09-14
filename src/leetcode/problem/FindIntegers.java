package leetcode.problem;

public class FindIntegers {
    /**
     * 600. 不含连续1的非负整数
     * https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones/
     */
    public int findIntegers(int num) {
        if (num < 3) {
            return num + 1;
        }
        if (num == 3) {
            return 3;
        }
        char[] c = Integer.toString(num, 2).toCharArray();
        int length = c.length;
        int[] dp = new int[length];
        boolean isChanged = false;
        for (int i = 1; i < length; i++) {
            if (isChanged) {
                c[i] = (c[i - 1] == '0') ? '1' : '0';
            } else if ((c[i] == '1') && (c[i - 1] == '1')) {
                c[i] = '0';
                isChanged = true;
            }
        }
        dp[length - 1] = 1;
        dp[length - 2] = 2;
        for (int i = length - 3; i > -1; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        int ans = 0;
        for (int i = 0; i < length; i++) {
            if (c[i] == '1') {
                ans += dp[i];
            }
        }
        return ans;
    }
}
