package leetcode.problem;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 * https://leetcode.cn/problems/matchsticks-to-square/
 */
public class Makesquare {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int ms : matchsticks) {
            sum += ms;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return find(matchsticks, matchsticks.length - 1, new int[4], sum / 4);
    }

    private boolean find(int[] nums, int pos, int[] sum, int target) {
        if (pos == -1) {
            return sum[0] == target && sum[1] == target && sum[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sum[i] + nums[pos] <= target) {
                sum[i] += nums[pos];
                if (find(nums, pos - 1, sum, target)) {
                    return true;
                }
                sum[i] -= nums[pos];
            }
        }
        return false;
    }
}
