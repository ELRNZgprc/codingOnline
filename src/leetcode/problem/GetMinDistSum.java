package leetcode.problem;

public class GetMinDistSum {
	/**
	 * 1515. 服务中心的最佳位置
	 * https://leetcode-cn.com/problems/best-position-for-a-service-centre/
	 */
	public double getMinDistSum(int[][] positions) {
		if (positions.length < 2) {
			return 0;
		}
		double x = 0;
		double y = 0;
		for (int[] position : positions) {
			x += position[0];
			y += position[1];
		}
		x /= positions.length;
		y /= positions.length;
		double dd = distance(x, y, positions);
		double step = 10.0;
		double dxx = dx(x, y, positions);
		double dyy = dy(x, y, positions);
		double dxy = dd;
		while (Math.abs(dxy) >= 0.0000005) {
			x -= dxx * step;
			y -= dyy * step;
			double ndd = distance(x, y, positions);
			if (ndd > dd) {
				step /= 2;
			}
			dxy = ndd - dd;
			dd = ndd;
			dxx = dx(x, y, positions);
			dyy = dy(x, y, positions);
		}
		return dd;
	}

	double distance(double x, double y, int[][] positions) {
		double d = 0;
		for (int[] position : positions) {
			d += Math.sqrt((position[0] - x) * (position[0] - x) + (position[1] - y) * (position[1] - y));
		}
		return d;
	}

	double dx(double x, double y, int[][] positions) {
		double d = 0;
		for (int[] position : positions) {
			if ((x != position[0]) || (y != position[1])) {
				d += (x - position[0])
						/ Math.sqrt((position[0] - x) * (position[0] - x) + (position[1] - y) * (position[1] - y));
			}
		}
		return d;
	}

	double dy(double x, double y, int[][] positions) {
		double d = 0;
		for (int[] position : positions) {
			if ((x != position[0]) || (y != position[1])) {
				d += (y - position[1])
						/ Math.sqrt((position[0] - x) * (position[0] - x) + (position[1] - y) * (position[1] - y));
			}
		}
		return d;
	}
}
