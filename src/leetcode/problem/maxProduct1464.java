package leetcode.problem;

import java.util.Arrays;

public class maxProduct1464 {
    /**
     * 1464
     * https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
     */
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
