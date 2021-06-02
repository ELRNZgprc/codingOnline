package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        if (k == 0) return false;
        if (k < 0) k = -k;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int mod = 0;
        for (int i = 0; i < nums.length; ++i) {
            mod = (mod + nums[i]) % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1)
                    return true;
            } else
                map.put(mod, i);
        }
        return false;
    }
}
