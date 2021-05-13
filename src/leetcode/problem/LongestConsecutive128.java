package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if ((map.containsKey(num + 1)) && (map.containsValue(num - 1))) {
                for (int k : map.keySet()) {
                    if (map.get(k) == num - 1) {
                        map.replace(k, map.get(num + 1));
                        map.remove(num + 1);
                        break;
                    }
                }
            } else if (map.containsKey(num + 1)) {
                map.put(num, map.get(num + 1));
                map.remove(num + 1);
            } else if (map.containsValue(num - 1)) {
                for (int k : map.keySet()) {
                    if (map.get(k) == num - 1) {
                        map.replace(k, num);
                        break;
                    }
                }
            } else {
                boolean needAdd = true;
                for (int k : map.keySet()) {
                    if ((k <= num) && (map.get(k) >= num)) {
                        needAdd = false;
                        break;
                    }
                }
                if (needAdd) {
                    map.put(num, num);
                }
            }
        }

        int ans = 0;
        for (int k : map.keySet()) {
            ans = Math.max(ans, map.get(k) - k + 1);
        }
        return ans;
    }
}
