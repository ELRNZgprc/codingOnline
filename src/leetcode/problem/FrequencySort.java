package leetcode.problem;

public class FrequencySort {
	/**
	 * 451. 根据字符出现频率排序
	 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
	 */
	public String frequencySort(String s) {
		if (s == null) {
			return s;
		}
		int[] counter = new int[128];
		char[] cs = s.toCharArray();
		for (char c : cs) {
			counter[c]++;
		}
		int curr = 0;
		while (curr < cs.length) {
			int count = 0;
			char c = 0;
			for (int i = 0; i <= 'z'; i++) {
				if (counter[i] > count) {
					count = counter[i];
					c = (char) i;
				}
			}
			counter[c] = 0;
			while (count-- > 0) {
				cs[curr++] = c;
			}
		}
		return new String(cs);
	}
}
