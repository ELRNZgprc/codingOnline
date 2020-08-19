package leetcode.mst;

public class MaxSubArray {
    /**
     * 面试题 16.17. 连续数列
     * https://leetcode-cn.com/problems/contiguous-sequence-lcci/
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            max = Math.max(sum, max);
        }
        return max;
    }
}
