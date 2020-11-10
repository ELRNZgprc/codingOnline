package leetcode.problem;

public class FindMaxConsecutiveOnes {
	/**
	 * 487. 最大连续1的个数 II
	 * https://leetcode-cn.com/problems/max-consecutive-ones-ii/
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		int ans = 0;
		int now = 0;
		int pre = 0;
		for (int num : nums) {
			if (num == 1) {
				now++;
			} else {
				ans = Math.max(ans, pre + now + 1);
				pre = now;
				now = 0;
			}
		}
		ans = Math.max(ans, pre + now + 1);
		if (now == nums.length) {
			ans = now;
		}
		return ans;
	}
}
