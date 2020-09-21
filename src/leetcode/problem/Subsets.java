package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	/**
	 * 78. 子集
	 * https://leetcode-cn.com/problems/subsets/
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			int all = res.size();
			for (int j = 0; j < all; j++) {
				List<Integer> tmp = new ArrayList<>(res.get(j));
				tmp.add(nums[i]);
				res.add(tmp);
			}
		}
		return res;
	}
}
