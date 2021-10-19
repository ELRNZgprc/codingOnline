package leetcode.problem;

/**
 * 1155. 掷骰子的N种方法
 * https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class NumRollsToTarget {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] ans = new int[d + 1][target + 1];
        for (int i = 1; i <= Math.min(f, target); i++) {
            ans[1][i] = 1;
        }
        for (int i = 1; i <= d; i++) {
            for (int k = 1; k <= f; k++) {
                for (int j = 1; j <= Math.min(f * d, target); j++) {
                    if (j >= k) {
                        ans[i][j] = (ans[i][j] + ans[i - 1][j - k]) % 1000000007;
                    }
                }
            }
        }
        return ans[d][target];
    }
}
