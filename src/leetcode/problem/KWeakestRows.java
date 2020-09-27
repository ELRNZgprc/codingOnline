package leetcode.problem;

import java.util.Arrays;

public class KWeakestRows {
	/**
	 * 1337. 方阵中战斗力最弱的 K 行
	 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
	 */
	public int[] kWeakestRows(int[][] mat, int k) {
		int[][] record = new int[k][2];
		for (int i = 0; i < k; i++) {
			int count = mat[i][0];
			int j = 0;
			while ((j + 1 < mat[i].length) && (mat[i][j + 1] == 1)) {
				j++;
				count++;
			}
			record[i] = new int[] { i, count };
		}
		Arrays.sort(record, (o1, o2) -> {
			return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
		});
		for (int i = k; i < mat.length; i++) {
			int count = mat[i][0];
			int j = 0;
			while ((j + 1 < mat[i].length) && (mat[i][j + 1] == 1)) {
				j++;
				count++;
			}
			j = 0;
			while ((j < k) && (count >= record[j][1])) {
				j++;
			}
			if (j < k) {
				for (int jj = k - 1; jj > j; jj--) {
					record[jj] = record[jj - 1];
				}
				record[j] = new int[] { i, count };
			}
		}
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = record[i][0];
		}
		return ans;
	}
}
