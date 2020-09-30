package leetcode.problem;

import java.util.Arrays;

public class TwoSumLessThanK {
	/**
	 * 1099. 小于 K 的两数之和
	 * https://leetcode-cn.com/problems/two-sum-less-than-k/
	 */
	public int twoSumLessThanK(int[] A, int K) {
		if (A.length < 2) {
			return -1;
		}
		Arrays.sort(A);
		int left = 0;
		int right = A.length - 1;
		int ans = -1;
		while (left < right) {
			if (A[left] + A[right] >= K) {
				right--;
			} else {
				ans = Math.max(A[left] + A[right], ans);
				left++;
			}
		}
		return ans;
	}
}
