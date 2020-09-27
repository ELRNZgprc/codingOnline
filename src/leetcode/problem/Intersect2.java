package leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersect2 {
	/**
	 * 350. 两个数组的交集 II
	 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int num : nums1) {
			map.put((Integer)num, map.getOrDefault((Integer)num,0)+1);
		}
		List<Integer> ansList = new ArrayList<>();
		for (int num : nums2) {
			if (map.keySet().contains(num)) {
				ansList.add(num);
				if (map.get((Integer) num)>1) {
					map.put((Integer)num, map.get((Integer)num)-1);
				}else{
					map.remove((Integer) num);
				}
			}
		}
		int[] ans = new int[ansList.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = ansList.get(i);
		}
		return ans;
	}
}
