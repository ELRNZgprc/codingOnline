package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2342. 数位和相等数对的最大和
 * https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
 */
public class MaximumSum {
    public int maximumSum(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i : nums) {
            int ii = i;
            int h = 0;
            while (ii > 0) {
                h += ii % 10;
                ii /= 10;
            }
            if (hash.containsKey(h)) {
                int max = hash.get(h);
                ans = Math.max(ans, max + i);
                if (i > max) {
                    hash.put(h, i);
                }
            } else {
                hash.put(h, i);
            }
        }
        return ans;
    }
}
