package leetcode.problem;

import java.util.Arrays;

/**
 * 1760. 袋子里最少数目的球
 * https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/
 */
public class MinimumSize {
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums[nums.length - 1];
        int ans = right;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int count = 0;
            for (int num : nums) {
                count += num / mid;
                if (num % mid == 0) {
                    count--;
                }
            }
            if (count <= maxOperations) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
