package leetcode.problem;

import java.util.Arrays;

public class FindLongestChain {
    /**
     * 646. 最长数对链
     * https://leetcode-cn.com/problems/maximum-length-of-pair-chain/
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (v1, v2) -> (v1[0] - v2[0]));
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[pairs.length - 1];
    }
}
