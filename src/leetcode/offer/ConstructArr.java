package leetcode.offer;

public class ConstructArr {
	/**
	 * 剑指 Offer 66. 构建乘积数组
	 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
	 */
	public int[] constructArr(int[] a) {
		if (a.length <= 1) {
			return a;
		}
		int[] ans = new int[a.length];
		ans[0] = 1;
		for (int i = 1; i < a.length; i++) {
			ans[i] = ans[i - 1] * a[i - 1];
		}
		int right = 1;
		for (int i = a.length - 2; i > -1; i--) {
			right = right * a[i + 1];
			ans[i] *= right;
		}
		return ans;
	}
}
