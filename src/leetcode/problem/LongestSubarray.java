package leetcode.problem;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int res = 0, sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += (nums[right] & 1);
            while (left < right && sum <= right - left - 1) {
                if (nums[left] == 1) {
                    sum--;
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
