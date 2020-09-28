package leetcode.problem;

public class ValidSubarrays {
    /**
     * 1063. 有效子数组的数目
     * https://leetcode-cn.com/problems/number-of-valid-subarrays/
     */
    public int validSubarrays(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
