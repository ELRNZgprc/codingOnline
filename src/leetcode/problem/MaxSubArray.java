package leetcode.problem;

public class MaxSubArray {
    /**
     * 53. 最大子序和
     * https://leetcode-cn.com/problems/maximum-subarray/
     */
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = ((sum > 0) ? sum : 0) + num;
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
