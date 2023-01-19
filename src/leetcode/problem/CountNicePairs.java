package leetcode.problem;

import java.util.HashMap;

/**
 * 1814. 统计一个数组中好对子的数目
 * https://leetcode.cn/problems/count-nice-pairs-in-an-array/
 */
public class CountNicePairs {
    public int countNicePairs(int[] nums) {
        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int rev = 0;
            while (num > 0) {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            diff[i] = rev - nums[i];
        }

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int dif : diff) {
            map.put(dif, map.getOrDefault(dif, 0) + 1);
        }
        for (int value : map.values()) {
            res += ((long) value * (value - 1) / 2) % (1000000007);
        }
        return res % 1000000007;
    }
}
