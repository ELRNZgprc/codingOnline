package leetcode.problem;

public class SingleNumber {
	/**
	 * 136. 只出现一次的数字
	 * https://leetcode-cn.com/problems/single-number/
	 */
	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int n : nums) {
			ans = ans ^ n;
		}
		return ans;
	}
}
