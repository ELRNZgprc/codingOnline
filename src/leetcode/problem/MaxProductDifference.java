package leetcode.problem;

import java.util.Arrays;

/**
 * 1913. 两个数对之间的最大乘积差
 * https://leetcode.cn/problems/maximum-product-difference-between-two-pairs/
 */
public class MaxProductDifference {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }
}
