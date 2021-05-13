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
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == num - 1) {
                        entry.setValue(map.get(num + 1));
                        map.remove(num + 1);
                        break;
                    }
                }
            } else if (map.containsKey(num + 1)) {
                map.put(num, map.get(num + 1));
                map.remove(num + 1);
            } else if (map.containsValue(num - 1)) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == num - 1) {
                        entry.setValue(num);
                        break;
                    }
                }
            } else {
                boolean needAdd = true;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if ((entry.getKey() <= num) && (entry.getValue() >= num)) {
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
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans = Math.max(ans, entry.getValue() - entry.getKey() + 1);
        }
        return ans;
    }
}
