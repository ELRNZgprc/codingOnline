package leetcode.problem;

import java.util.Arrays;

public class MaxProduct1464 {
    /**
     * 1464 1464. 数组中两元素的最大乘积
     * https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
     */
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
