package leetcode.problem;

public class KLengthApart {
	/**
	 * 1437. 是否所有 1 都至少相隔 k 个元素
	 * https://leetcode-cn.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
	 */
	public boolean kLengthApart(int[] nums, int k) {
		int before = -100000;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				if (i - before - 1 < k) {
					return false;
				}
				before = i;
			}
		}
		return true;
	}
}
