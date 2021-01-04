package leetcode.problem;

import java.util.Arrays;

public class FindRadius {
	/**
	 * 475. 供暖器
	 * https://leetcode-cn.com/problems/heaters/
	 */
	public int findRadius(int[] houses, int[] heaters) {
		int ans = 0;
		Arrays.sort(houses);
		Arrays.sort(heaters);

		int right = 0;
		for (int i = 0; i < houses.length; i++) {
			while ((right < heaters.length - 1) && (heaters[right] < houses[i])) {
				right++;
			}

			int dis = Math.abs(heaters[right] - houses[i]);
			if (right > 0) {
				dis = Math.min(dis, Math.abs(heaters[right - 1] - houses[i]));
			}
			ans = Math.max(ans, dis);
		}

		return ans;
	}
}
