package leetcode.problem;

public class MinEatingSpeed {
	/**
	 * 875. 爱吃香蕉的珂珂 
	 * https://leetcode-cn.com/problems/koko-eating-bananas/
	 */
	public int minEatingSpeed(int[] piles, int H) {
		int max = piles[0];
		for (int i = 1; i < piles.length; i++) {
			max = Math.max(max, piles[i]);
		}
		int min = 1;
		while (min < max) {
			int mid = (min + max) / 2;
			int count = 0;
			for (int i = 0; i < piles.length; i++) {
				count += piles[i] / mid;
				if (piles[i] % mid != 0)
					count++;
			}
			if (count > H) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}
}
