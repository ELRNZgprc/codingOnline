package leetcode.problem;

public class numberOfArithmeticSlices {
    /**
     * 413
     * https://leetcode-cn.com/problems/arithmetic-slices/
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if ((2 * A[i - 1]) == (A[i] + A[i - 2])) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += dp[i];
        }
        return ans;
    }
}
