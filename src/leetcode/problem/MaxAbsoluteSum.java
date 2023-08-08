package leetcode.problem;

/**
 * 1749. 任意子数组和的绝对值的最大值
 * https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/
 */
public class MaxAbsoluteSum {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, max = 0, min = 0;
        for (int val : nums) {
            sum += val;
            if (sum > max) {
                max = sum;
            } else if (sum < min) {
                min = sum;
            }
        }
        return max - min;
    }
}
