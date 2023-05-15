package leetcode.problem;

/**
 * 2680. 最大或值
 * https://leetcode.cn/problems/maximum-or/
 */
public class MaximumOr {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] pre1 = new int[n + 5];
        int[] pre2 = new int[n + 5];
        for (int i = 0; i < n; i++) {
            pre1[i + 1] = pre1[i] | nums[i];
            pre2[n - i - 1] = pre2[n - i] | nums[n - i - 1];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (long) nums[i] << k | pre1[i] | pre2[i + 1]);
        }
        return ans;
    }
}
