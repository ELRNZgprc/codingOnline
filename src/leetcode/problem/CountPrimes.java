package leetcode.problem;

public class CountPrimes {
	/**
	 * 204. 计数质数
	 * https://leetcode-cn.com/problems/count-primes/
	 */
	public int countPrimes(int n) {
		int[] p = new int[n];
		int ans = 0;
		for (int i = 2; i < n; i++) {
			if (p[i] == 0) {
				ans++;
				for (int j = i * 2; j < n; j += i) {
					p[j] = 1;
				}
			}
		}
		return ans;
	}
}
