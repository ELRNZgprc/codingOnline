package leetcode.problem;

/**
 * 1248. 统计「优美子数组」
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0, count = 0;
        int left = 0, right = 0;
        int tmp = 0;
        while (right < nums.length) {
            if (count < k) {
                count += nums[right] & 1;
                right++;
            }
            if (count == k) {
                tmp = 0;
                while (count == k) {
                    ans++;
                    tmp++;
                    count -= nums[left] & 1;
                    left++;
                }
            } else {
                ans += tmp;
            }
        }
        return ans;
    }
}
