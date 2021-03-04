package leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
	/**
	 * 354. 俄罗斯套娃信封问题
	 * https://leetcode-cn.com/problems/russian-doll-envelopes/
	 */
	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
			}
		});
		int[] dp = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			int tmp = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					tmp = Math.max(tmp, dp[j] + 1);
				}
			}
			dp[i] = tmp;
			max = Math.max(tmp, max);
		}
		return max;
	}
}
