package leetcode.problem;

import java.util.Arrays;

public class SortByBits {
	/**
	 * 1356. 根据数字二进制下 1 的数目排序
	 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
	 */
	public int[] sortByBits(int[] arr) {
		int[][] res = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			int n = arr[i];
			int c = 0;
			while (n != 0) {
				if (n % 2 == 1) {
					c++;
				}
				n /= 2;
			}
			res[i][0] = arr[i];
			res[i][1] = c;
		}
		Arrays.sort(res, (o1, o2) -> {
			return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
		});
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ans[i] = res[i][0];
		}
		return ans;
	}
}
