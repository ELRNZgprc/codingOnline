package leetcode.mst;

public class TrailingZeroes {
	/**
	 * 面试题 16.05. 阶乘尾数
	 * https://leetcode-cn.com/problems/factorial-zeros-lcci/
	 */
	public int trailingZeroes(int n) {
		int ans = 0;
		long pow = 5;
		while (pow <= n) {
			ans += n / pow;
			pow *= 5;
		}
		return ans;
	}
}
