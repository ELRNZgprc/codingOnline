package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2404. 出现最频繁的偶数元素
 * https://leetcode.cn/problems/most-frequent-even-element/
 */
public class MostFrequentEven {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        int maxcount = 0;
        for (int n : nums) {
            if (n % 2 == 0) {
                int count = map.getOrDefault(n, 0) + 1;
                if ((ans == -1) || (count > maxcount) || ((count == maxcount) && (n < ans))) {
                    ans = n;
                    maxcount = count;
                }
                map.put(n, count);
            }
        }
        return ans;
    }
}
