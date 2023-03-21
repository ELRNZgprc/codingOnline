package leetcode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2395. 和相等的子数组
 * https://leetcode.cn/problems/find-subarrays-with-equal-sum/
 */
public class FindSubarrays {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = nums[1] + nums[0];
        set.add(sum);
        for (int i = 2; i < nums.length; i++) {
            sum = nums[i - 1] + nums[i];
            if (set.contains(sum)) {
                return true;
            } else {
                set.add(sum);
            }
        }
        return false;
    }
}

