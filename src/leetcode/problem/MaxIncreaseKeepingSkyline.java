package leetcode.problem;

public class MaxIncreaseKeepingSkyline {
	/**
	 * 807. 保持城市天际线
	 * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
	 */
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int ans = 0;
		int[] row = new int[grid.length];

		int[] col = grid[0].clone();
		for (int i = 0; i < grid.length; i++) {
			row[i] = grid[i][0];
			for (int j = 0; j < grid[i].length; j++) {
				row[i] = Math.max(row[i], grid[i][j]);
				col[j] = Math.max(col[j], grid[i][j]);
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				ans += (Math.min(row[i], col[j]) - grid[i][j]);
			}
		}
		return ans;
	}
}
