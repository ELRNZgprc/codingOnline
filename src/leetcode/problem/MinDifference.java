package leetcode.problem;

import java.util.Arrays;

public class MinDifference {
    /**
     * 1509. 三次操作后最大值与最小值的最小差
     * https://leetcode-cn.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
     */
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            ans = Math.min(ans, nums[nums.length - 1 - i] - nums[3 - i]);
        }
        return ans;
    }
}
