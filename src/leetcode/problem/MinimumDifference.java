package leetcode.problem;

import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 * https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class MinimumDifference {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int l = 0, r = k - 1; r < nums.length; )
            res = Math.min(res, nums[r++] - nums[l++]);
        return res;
    }
}
