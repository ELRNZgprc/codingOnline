package leetcode.problem;

import java.util.Arrays;

/**
 * 2708. 一个小组的最大实力值
 * https://leetcode.cn/problems/maximum-strength-of-a-group/
 */
public class MaxStrength {
    public long maxStrength(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        long ans = 1L;
        boolean flag = false;

        for (int i = 0; i < len; i++) {
            if (i < len - 1 && nums[i] < 0 && nums[i + 1] < 0) {
                ans *= (long) nums[i] * nums[i + 1];
                i++;
                flag = true;
            } else if (nums[i] > 0) {
                ans *= nums[i];
                flag = true;
            }
        }
        return flag ? ans : nums[len - 1];
    }
}
