package leetcode.problem;

/**
 * 1848. 到目标元素的最小距离
 * https://leetcode-cn.com/problems/minimum-distance-to-the-target-element/
 */
public class GetMinDistance {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = 0;
        while ((start + ans < nums.length) || (start - ans > -1)) {
            if ((start + ans < nums.length) && (nums[start + ans] == target)) {
                return ans;
            }
            if ((start - ans > -1) && (nums[start - ans] == target)) {
                return ans;
            }
            ans++;
        }
        return -1;
    }
}
