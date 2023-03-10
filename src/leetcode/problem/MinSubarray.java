package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1590. 使数组和能被 P 整除
 * https://leetcode.cn/problems/make-sum-divisible-by-p/
 */
public class MinSubarray {
    public int minSubarray(int[] nums, int p) {
        long m = 0, num = 0;
        for (int i = 0; i < nums.length; i++) {
            m += nums[i];
        }
        if (m % p == 0) return 0;
        if (m < p) return -1;
        m %= p;
        int min = nums.length;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        for (int i = 0; i < nums.length; i++) {
            num += nums[i];
            num %= p;
            map.put(num, i);
            min = Math.min(min, i - map.getOrDefault(Math.abs(num >= m ? num - m : num - m + p), -nums.length));
        }
        return min == nums.length ? -1 : min;
    }
}
