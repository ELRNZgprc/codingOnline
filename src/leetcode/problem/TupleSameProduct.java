package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1726. 同积元组
 * https://leetcode.cn/problems/tuple-with-same-product/
 */
public class TupleSameProduct {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            res += map.get(key) * (map.get(key) - 1) * 4;
        }
        return res;
    }
}
