package leetcode.problem;

import java.util.Arrays;

/**
 * 2731. 移动机器人
 * https://leetcode.cn/problems/movement-of-robots/
 */
public class SumDistance {
    static final int m = 1000000007;

    public int sumDistance(int[] nums, String s, int d) {
        long[] location = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            location[i] = (nums[i] + d * (s.charAt(i) == 'R' ? 1 : -1));
        }
        Arrays.sort(location);
        long res = 0;
        for (int i = 1; i < nums.length; i++) {
            res += 1L * (location[i] - location[i - 1]) * i % m * (nums.length - i) % m;
            res %= m;
        }
        return (int) (res % m);
    }
}
