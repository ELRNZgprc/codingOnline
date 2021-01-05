package leetcode.problem;

public class MinArea {
	/**
	 * 302. 包含全部黑色像素的最小矩形
	 * https://leetcode-cn.com/problems/smallest-rectangle-enclosing-black-pixels/
	 */
	public int minArea(char[][] image, int x, int y) {
		int top = 0;
		int bottom = image.length;
		int left = image[0].length;
		int right = 0;
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				if (image[i][j] == '1') {
					top = Math.max(top, i);
					bottom = Math.min(bottom, i);
					left = Math.min(left, j);
					right = Math.max(right, j);
				}
			}
		}
		return (top - bottom + 1) * (right - left + 1);
	}
}
