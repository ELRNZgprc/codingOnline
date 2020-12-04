package leetcode.problem;

import java.util.HashSet;
import java.util.Set;

public class HasAllCodes {
	/**
	 * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
	 * https://leetcode-cn.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
	 */
	public boolean hasAllCodes(String s, int k) {
		int left = 0, right = k;
		int len = s.length();
		Set<String> set = new HashSet<>();
		while (right <= len) {
			set.add(s.substring(left, right));
			left++;
			right++;
		}
		if (set.size() == Math.pow(2, k))
			return true;
		return false;
	}
}
