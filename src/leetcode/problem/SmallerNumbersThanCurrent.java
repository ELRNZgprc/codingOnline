package leetcode.problem;

public class SmallerNumbersThanCurrent {
	/**
	 * 1365. 有多少小于当前数字的数字
	 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
	 */
	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] arrays = new int[101];
		for (int num : nums)
			arrays[num] += 1;
		for (int i = 1; i < arrays.length; i++)
			arrays[i] += arrays[i - 1];
		for (int i = 0; i < nums.length; i++)
			nums[i] = nums[i] != 0 ? arrays[nums[i] - 1] : 0;
		return nums;
	}
}
