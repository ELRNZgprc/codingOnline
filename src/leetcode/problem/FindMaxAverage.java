package leetcode.problem;

public class FindMaxAverage {
    /**
     * 643. 子数组最大平均数 I
     * https://leetcode-cn.com/problems/maximum-average-subarray-i/
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double ans = sum;
        for (int i = 1; i < nums.length - k + 1; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            ans = Math.max(sum, ans);
        }
        return ans / k;
    }
}
