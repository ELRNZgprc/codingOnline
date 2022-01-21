package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 */
public class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (map.containsKey(sum - goal)) {
                ans += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
