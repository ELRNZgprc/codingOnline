package leetcode.problem;

public class ContainsNearbyAlmostDuplicate {
	/**
	 * 220. 存在重复元素 III
	 * https://leetcode-cn.com/problems/contains-duplicate-iii/
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length; i++) {
			int end = Math.min(i + k + 1, nums.length);
			for (int j = i + 1; j < end; j++) {
				if (Math.abs((long) nums[j] - (long) nums[i]) <= t) {
					return true;
				}
			}
		}
		return false;
	}
}
