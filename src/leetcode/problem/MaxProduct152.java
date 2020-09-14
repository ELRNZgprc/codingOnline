package leetcode.problem;

public class MaxProduct152 {
    /**
     * 152. 乘积最大子数组
     * https://leetcode-cn.com/problems/maximum-product-subarray/
     */
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
