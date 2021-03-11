package leetcode.problem;

public class DistanceBetweenBusStops {
	/**
	 * 1184. 公交站间的距离
	 * https://leetcode-cn.com/problems/distance-between-bus-stops/
	 */
	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int d1 = 0, d2 = 0;
		int l = Math.min(start, destination);
		int r = Math.max(start, destination);
		for (int i = 0; i < distance.length; i++) {
			if (i >= l && i < r) {
				d1 += distance[i];
			} else {
				d2 += distance[i];
			}
		}
		return d1 < d2 ? d1 : d2;
	}
}
