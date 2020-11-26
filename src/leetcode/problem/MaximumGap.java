package leetcode.problem;

import java.util.Arrays;

public class MaximumGap {
	/**
	 * 164. 最大间距
	 * https://leetcode-cn.com/problems/maximum-gap/
	 */
	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;
		Arrays.sort(nums);
		int temp = 0;
		int res = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			temp = nums[i + 1] - nums[i];
			res = Math.max(res, temp);
		}
		return res;
	}
}
