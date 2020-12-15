package leetcode.problem;

import java.util.Arrays;

public class BagOfTokensScore {
	/**
	 * 948. 令牌放置
	 * https://leetcode-cn.com/problems/bag-of-tokens/
	 */
	public int bagOfTokensScore(int[] tokens, int P) {
		Arrays.sort(tokens);
		int left = 0;
		int right = tokens.length - 1;
		int ans = 0;

		while (left <= right) {
			if (tokens[left] > P) {
				if (ans > 0) {
					P += (tokens[right] - tokens[left]);
					right--;
					left++;
				} else {
					return ans;
				}
			} else {
				P -= tokens[left];
				left++;
				ans++;
			}
		}

		return ans;
	}
}
