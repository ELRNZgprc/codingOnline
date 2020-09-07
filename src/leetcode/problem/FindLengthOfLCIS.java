package leetcode.problem;

public class FindLengthOfLCIS {
    /**
     * 674. 最长连续递增序列
     * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
     */
    public int findLengthOfLCIS(int[] nums) {
        int i = 0;
        int ans = 0;
        while (i < nums.length) {
            int j = i;
            while ((j + 1 < nums.length) && (nums[j + 1] > nums[j])) {
                j++;
            }
            ans = Math.max(ans, j - i + 1);
            i = j + 1;
        }
        return ans;
    }
}
