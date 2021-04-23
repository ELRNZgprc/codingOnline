package leetcode.problem;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 * https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 */
public class FindMinFibonacciNumbers {
		public int findMinFibonacciNumbers(int k) {
		if (k == 0) {
			return 0;
		}
		int a = 1;
		int b = 1;
		while (b <= k) {
			int c = b;
			b = a + b;
			a = c;
		}
		return 1 + findMinFibonacciNumbers(k - a);
	}
}
