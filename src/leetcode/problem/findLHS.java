package leetcode.problem;

import java.util.Arrays;

public class findLHS {
    /**
     * 594
     * https://leetcode-cn.com/problems/longest-harmonious-subsequence/
     */
    public int findLHS(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = left;
        int ans = 0;
        while (right < nums.length) {
            right = left + 1;
            while ((right < nums.length) && (nums[right] == nums[left])) {
                right++;
            }
            if ((right < nums.length) && (nums[right] == nums[left] + 1)) {
                int newright = right;
                while ((newright < nums.length) && (nums[newright] == nums[left] + 1)) {
                    newright++;
                }
                ans = Math.max(ans, newright - left);
            }
            left = right;
        }

        return ans;
    }
}
