package leetcode.problem;

public class integerBreak {
    /**
     * 343
     * https://leetcode-cn.com/problems/integer-break/
     */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                ans[i] = Math.max(ans[i], ans[j] * (i - j));
            }
        }
        return ans[n];
    }
}
