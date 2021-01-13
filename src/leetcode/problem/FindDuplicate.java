package leetcode.problem;

public class FindDuplicate {
	/**
	 * 287. 寻找重复数
	 * https://leetcode-cn.com/problems/find-the-duplicate-number/
	 */
	public int findDuplicate(int[] nums) {
		int fast = 0, slow = 0;
		while (true) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			if (slow == fast) {
				fast = 0;
				while (nums[slow] != nums[fast]) {
					fast = nums[fast];
					slow = nums[slow];
				}
				return nums[slow];
			}
		}
	}
}
