package leetcode.problem;

public class Trap {
	/**
	 * 42. 接雨水
	 * https://leetcode-cn.com/problems/trapping-rain-water/
	 */
	public int trap(int[] height) {
		int[] level = new int[height.length];
		int max = 0;
		for (int i = 0; i < level.length; i++) {
			max = Math.max(height[i], max);
			level[i] = max;
		}
		max = 0;
		int ans = 0;
		for (int i = level.length - 1; i > -1; i--) {
			max = Math.max(height[i], max);
			level[i] = Math.min(level[i], max);
			if (level[i] > height[i]) {
				ans += level[i] - height[i];
			}
		}
		return ans;
	}
}
