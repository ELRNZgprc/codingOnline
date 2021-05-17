package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * https://leetcode-cn.com/problems/contiguous-array/
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
