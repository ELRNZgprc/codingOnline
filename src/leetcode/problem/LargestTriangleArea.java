package leetcode.problem;

public class LargestTriangleArea {
	/**
	 * 812. 最大三角形面积
	 * https://leetcode-cn.com/problems/largest-triangle-area/
	 */
	public double largestTriangleArea(int[][] points) {
		double ans = 0;
		for (int i = 0; i < points.length - 2; i++) {
			for (int j = i + 1; j < points.length - 1; j++) {
				for (int k = j + 1; k < points.length; k++) {
					ans = Math.max(ans, s(i, j, k, points));
				}
			}
		}
		return ans;
	}

	double s(int x, int y, int z, int[][] p) {
		double a = Math.sqrt(((p[x][0] - p[y][0]) * (p[x][0] - p[y][0]) + (p[x][1] - p[y][1]) * (p[x][1] - p[y][1])));
		double b = Math.sqrt(((p[x][0] - p[z][0]) * (p[x][0] - p[z][0]) + (p[x][1] - p[z][1]) * (p[x][1] - p[z][1])));
		double c = Math.sqrt(((p[y][0] - p[z][0]) * (p[y][0] - p[z][0]) + (p[y][1] - p[z][1]) * (p[y][1] - p[z][1])));
		double h = (a + b + c) / 2.0;
		return Math.sqrt(Math.abs(h * (h - a) * (h - b) * (h - c)));
	}
}
