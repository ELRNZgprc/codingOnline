package leetcode.problem;

/**
 * 1827. 最少操作使数组递增
 * https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-increasing/
 */
public class MinOperations1827 {
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }
}
