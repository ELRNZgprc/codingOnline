package leetcode.problem;

public class FindMaxConsecutiveOnes1 {
	/**
	 * 485. 最大连续1的个数
	 * https://leetcode-cn.com/problems/max-consecutive-ones/
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		int ans = 0;
		int cur = 0;
		for (int n : nums) {
			if (n == 1) {
				cur++;
			} else {
				ans = Math.max(ans, cur);
				cur = 0;
			}
		}
		ans = Math.max(ans, cur);
		return ans;
	}
}
