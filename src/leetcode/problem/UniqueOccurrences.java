package leetcode.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueOccurrences {
	/**
	 * 1207. 独一无二的出现次数
	 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
	 */
	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> counter = new HashMap<>();
		for (int elem : arr)
			counter.put(elem, counter.getOrDefault(elem, 0) + 1);

		return counter.size() == new HashSet<Integer>(counter.values()).size();
	}
}
