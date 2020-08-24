package leetcode.offer;

public class MaxSubArray {
    /**
     * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
     */
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = ((sum > 0) ? sum : 0) + num;
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
