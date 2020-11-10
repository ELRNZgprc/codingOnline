package leetcode.problem;

public class NumWaterBottles {
	/**
	 * 1518. 换酒问题
	 * https://leetcode-cn.com/problems/water-bottles/
	 */
	public int numWaterBottles(int numBottles, int numExchange) {
		int ans = numBottles;
		while (numBottles >= numExchange) {
			int newBottles = numBottles / numExchange;
			ans += newBottles;
			numBottles = (numBottles % numExchange) + newBottles;
		}
		return ans;
	}
}
