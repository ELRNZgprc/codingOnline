package leetcode.problem;

import java.util.Arrays;

/**
 * 1877. 数组中最大数对和的最小值
 * https://leetcode.cn/problems/minimize-maximum-pair-sum-in-array/
 */
public class MinPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int ans = nums[left] + nums[right];
        left++;
        right--;
        while (left < right) {
            ans = Math.max(ans, nums[left] + nums[right]);
            left++;
            right--;
        }
        return ans;
    }
}
