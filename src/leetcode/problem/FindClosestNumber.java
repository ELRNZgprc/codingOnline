package leetcode.problem;

/**
 * 2239. 找到最接近 0 的数字
 * https://leetcode.cn/problems/find-closest-number-to-zero/
 */
public class FindClosestNumber {
    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int n : nums) {
            if (Math.abs(n) < Math.abs(ans)) {
                ans = n;
            } else if (Math.abs(n) == Math.abs(ans)) {
                ans = Math.max(ans, n);
            }
        }
        return ans;
    }
}
