package leetcode.problem;

import java.util.Arrays;

/**
 * 1679. K 和数对的最大数目
 * https://leetcode-cn.com/problems/max-number-of-k-sum-pairs/
 */
public class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        int ans = 0;

        while (i < j) {
            if (nums[i] + nums[j] == k) {
                i++;
                j--;
                ans++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }
}
