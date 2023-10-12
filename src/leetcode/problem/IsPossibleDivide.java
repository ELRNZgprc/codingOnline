package leetcode.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1296. 划分数组为连续数字的集合
 * https://leetcode.cn/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class IsPossibleDivide {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : nums) {
            if (map.get(key) > 0) {
                int time = map.get(key);
                for (int i = 0; i < k; i++) {
                    if (!map.containsKey(key + i)) {
                        return false;
                    }
                    if (map.get(key + i) < time) {
                        return false;
                    }
                    map.put(key + i, map.get(key + i) - time);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
