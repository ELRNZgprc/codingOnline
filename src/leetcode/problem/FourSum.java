package leetcode.problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
	/**
	 * 18. 四数之和
	 * https://leetcode-cn.com/problems/4sum/
	 */
	List<List<Integer>> res = new LinkedList<>();
	List<Integer> list = new LinkedList<>();
	int[] nums;
	int target;
	int k;

	public List<List<Integer>> fourSum(int[] nums, int target) {
		this.nums = nums;
		this.target = target;
		this.k = 4;
		if (nums == null || nums.length < 4)
			return res;
		Arrays.sort(this.nums);
		huiSu(0, -1);
		return res;
	}

	public boolean huiSu(int sum, int pre) {
		if (list.size() == k) {
			if (sum == target)
				res.add(new LinkedList<>(list));
			return sum < target;
		}
		for (int i = pre + 1; i + k - list.size() <= nums.length; i++) {
			if (i > pre + 1 && nums[i] == nums[i - 1])
				continue;
			list.add(nums[i]);
			boolean flag = huiSu(sum + nums[i], i);
			list.remove(list.size() - 1);
			if (!flag)
				break;
		}
		return true;
	}
}
