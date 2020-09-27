package leetcode.lcp;

import java.util.Arrays;

public class BreakfastNumber {
	/**
	 * LCP 18. 早餐组合
	 * https://leetcode-cn.com/problems/2vYnGI/
	 */
	public int breakfastNumber(int[] staple, int[] drinks, int x) {
		Arrays.sort(staple);
		Arrays.sort(drinks);
		int ans = 0;
		int i = 0;
		int j = drinks.length - 1;
		while (i < staple.length && j >= 0) {
			if (staple[i] + drinks[j] > x)
				j--;
			else {
				ans += (j + 1);
				ans %= 1000000007;
				i++;
			}
		}
		return ans;
	}
}
