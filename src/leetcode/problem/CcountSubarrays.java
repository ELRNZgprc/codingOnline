package leetcode.problem;

import java.util.HashMap;

/**
 * 2488. 统计中位数为 K 的子数组
 * https://leetcode.cn/problems/count-subarrays-with-median-k/
 */
public class CcountSubarrays {
    public int countSubarrays(int[] nums, int k) {
        int location = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                location = i;
            }
        }
        HashMap<Integer, Integer> left = new HashMap<>();
        int count = 0;
        left.put(0, 1);
        for (int i = location - 1; i >= 0; i--) {
            if (nums[i] > k) {
                count++;
            } else if (nums[i] < k) {
                count--;
            }
            left.put(count, left.getOrDefault(count, 0) + 1);
        }
        count = 0;
        HashMap<Integer, Integer> right = new HashMap<>();
        right.put(0, 1);
        for (int i = location + 1; i < nums.length; i++) {
            if (nums[i] > k) {
                count++;
            } else if (nums[i] < k) {
                count--;
            }
            right.put(count, right.getOrDefault(count, 0) + 1);
        }
        int ans = 0;
        for (int i : left.keySet()) {
            if (right.containsKey(-i)) {
                ans += left.get(i) * right.get(-i);
            }
            if (right.containsKey(1 - i)) {
                ans += left.get(i) * right.get(1 - i);
            }
        }
        return ans;
    }
}
