package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class FindSubsequences {
	/**
	 * 491. 递增子序列
	 * https://leetcode-cn.com/problems/increasing-subsequences/
	 */
	List<Integer> temp = new ArrayList<Integer>();
	List<List<Integer>> ans = new ArrayList<List<Integer>>();

	public List<List<Integer>> findSubsequences(int[] nums) {
		dfs(Integer.MIN_VALUE, 0, nums);
		return ans;
	}

	public void dfs(int pre, int cur, int[] nums) {
		if (cur == nums.length) {
			if (temp.size() >= 2) {
				ans.add(new ArrayList<Integer>(temp));
			}
			return;
		}
		if (nums[cur] >= pre) {
			temp.add(nums[cur]);
			dfs(nums[cur], cur + 1, nums);
			temp.remove(temp.size() - 1);
		}
		if (nums[cur] != pre) {
			dfs(pre, cur + 1, nums);
		}
	}
}
