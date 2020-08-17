package leetcode.problem;

public class findLength {
    /**
     * 718
     * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
     */
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    if ((i != 0) && (j != 0)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
