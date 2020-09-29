package leetcode.problem;

public class ProjectionArea {
	/**
	 * 883. 三维形体投影面积
	 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
	 */
	public int projectionArea(int[][] grid) {
		int length = grid.length;
		int width = grid[0].length;
		int[] ll = new int[width];
		int[] ww = new int[length];

		int ans = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (grid[i][j] != 0) {
					ans++;
					ll[j] = Math.max(ll[j], grid[i][j]);
					ww[i] = Math.max(ww[i], grid[i][j]);
				}
			}
		}

		for (int i = 0; i < length; i++) {
			ans += ww[i];
		}
		for (int i = 0; i < width; i++) {
			ans += ll[i];
		}
		return ans;
	}
}
