package leetcode.problem;

/**
 * 1708. 长度为 K 的最大子数组
 * https://leetcode-cn.com/problems/largest-subarray-length-k/
 */
public class LargestSubarray {
    public int[] largestSubarray(int[] nums, int k) {
        int flag = 0;
        for (int i = 1; i < nums.length - k + 1; i++) {
            if (nums[i] > nums[flag]) {
                flag = i;
            }
        }
        int[] ans = new int[k];
        if (k >= 0) System.arraycopy(nums, flag, ans, 0, k);
        return ans;
    }
}
