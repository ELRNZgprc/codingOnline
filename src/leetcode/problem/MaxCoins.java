package leetcode.problem;

import java.util.Arrays;

public class MaxCoins {
	/**
	 * 1561. 你可以获得的最大硬币数目
	 * https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get/
	 */
	public int maxCoins(int[] piles) {
		int ans = 0;
		int n = piles.length / 3;
		Arrays.sort(piles);
		for (int i = 0; i < n; i++) {
			ans += piles[2 * i + n];
		}
		return ans;
	}
}
