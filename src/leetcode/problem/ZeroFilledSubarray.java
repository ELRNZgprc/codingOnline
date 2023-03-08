package leetcode.problem;

/**
 * 2348. 全 0 子数组的数目
 * https://leetcode.cn/problems/number-of-zero-filled-subarrays/
 */
public class ZeroFilledSubarray {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                count++;
            } else if (count > 0) {
                ans += (long) count * (count + 1) / 2;
                count = 0;
            }
            i++;
        }
        if (count > 0) {
            ans += (long) count * (count + 1) / 2;
        }
        return ans;
    }
}
