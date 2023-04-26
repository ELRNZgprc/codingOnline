package leetcode.problem;

import java.util.Arrays;

/**
 * 169. 多数元素
 * https://leetcode.cn/problems/majority-element/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
