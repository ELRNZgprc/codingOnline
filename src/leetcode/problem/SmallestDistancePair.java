package leetcode.problem;

import java.util.Arrays;

/**
 * 719. 找出第 K 小的数对距离
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 */
public class SmallestDistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            int res = check(nums, mid);
            if (res < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int check(int[] nums, int key) {
        int left = 0, right = 1;
        int res = 0;
        while (right < nums.length) {
            while (nums[right] - nums[left] > key) {
                left++;
            }
            res += right - left;
            right++;
        }
        return res;
    }
}
