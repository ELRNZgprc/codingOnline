package leetcode.problem;

import java.util.*;

public class Intersection {
	/**
	 * 349. 两个数组的交集
	 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}
		List<Integer> ansList = new ArrayList<>();
		for (int num : nums2) {
			if (set.contains(num)) {
				ansList.add(num);
				set.remove(num);
			}
		}
		int[] ans = new int[ansList.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = ansList.get(i);
		}
		return ans;
	}
}
