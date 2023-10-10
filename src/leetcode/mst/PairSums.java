package leetcode.mst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 16.24. 数对和
 * https://leetcode.cn/problems/pairs-with-sum-lcci/
 */
public class PairSums {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int k : map.keySet()) {
            if (map.containsKey(target - k)) {
                int t = Math.min(map.get(k), map.get(target - k));
                if (k * 2 == target) {
                    t /= 2;
                }
                for (int i = 0; i < t; i++) {
                    List<Integer> l = new ArrayList<>();
                    l.add(k);
                    l.add(target - k);
                    res.add(l);
                }
                map.put(k, map.get(k) - t);
                map.put(target - k, map.get(target - k) - t);
            }
        }
        return res;
    }
}
