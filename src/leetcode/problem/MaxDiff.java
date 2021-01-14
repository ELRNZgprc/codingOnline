package leetcode.problem;

public class MaxDiff {
	/**
	 * 1432. 改变一个整数能得到的最大差值
	 * https://leetcode-cn.com/problems/max-difference-you-can-get-from-changing-an-integer/
	 */
	public int maxDiff(int num) {
		String s = String.valueOf(num);
		int cnt = 0;
		char c = s.charAt(0);

		char[] maxChars = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (cnt == 0 && s.charAt(i) != '9') {
				c = s.charAt(i);
				cnt++;
				maxChars[i] = '9';
			} else if (cnt > 0 && s.charAt(i) == c) {
				maxChars[i] = '9';
			}
		}
		int max = Integer.valueOf(String.valueOf(maxChars));

		char[] minChars = s.toCharArray();
		char c1 = minChars[0];
		int flag = 0;
		if (minChars[0] != '1') {
			minChars[0] = '1';
			for (int i = 1; i < minChars.length; i++) {
				if (minChars[i] == c1) {
					minChars[i] = '1';
				}
			}
		} else {
			for (int i = 0; i < minChars.length; i++) {
				if (minChars[i] != '1' && minChars[i] != '0' && flag == 0) {
					c1 = minChars[i];
					flag++;
					minChars[i] = '0';
				} else if (minChars[i] == c1 && flag > 0) {
					minChars[i] = '0';
				}
			}
		}
		int min = Integer.valueOf(String.valueOf(minChars));

		return max - min;
	}
}
