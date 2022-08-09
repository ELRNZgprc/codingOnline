package leetcode.problem;

/**
 * 1413. 逐步求和得到正数的最小值
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class MinStartValue {
    public int minStartValue(int[] nums) {
        int tmp = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            tmp = Math.min(tmp, sum);
        }
        return Math.max(1, 1 - tmp);
    }
}
