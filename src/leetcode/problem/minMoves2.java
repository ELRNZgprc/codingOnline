package leetcode.problem;

import java.util.Arrays;

public class minMoves2 {
    /**
     * 462
     * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int target = (nums.length % 2 == 0) ? nums.length / 2 : (nums.length - 1) / 2;
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - nums[target]);
        }
        return ans;
    }
}
