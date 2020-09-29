package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class PrefixesDivBy5 {
	/**
	 * 1018. 可被 5 整除的二进制前缀
	 * https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
	 */
	public List<Boolean> prefixesDivBy5(int[] A) {
		int n = 0;
		List<Boolean> ans = new ArrayList<>();
		for (int i : A) {
			n = (n * 2 + i) % 10;
			ans.add(((n == 5) || (n == 0)));
		}
		return ans;
	}
}
