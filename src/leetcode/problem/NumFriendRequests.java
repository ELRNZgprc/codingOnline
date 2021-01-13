package leetcode.problem;

public class NumFriendRequests {
	/**
	 * 825. 适龄的朋友
	 * https://leetcode-cn.com/problems/friends-of-appropriate-ages/
	 */
	public int numFriendRequests(int[] ages) {
		int res = 0;
		int[] ans = new int[150];
		for (int i = 0; i < ages.length; ++i) {
			ans[ages[i]]++;
		}
		for (int i = 15; i < 150; ++i) {
			if (ans[i] != 0)
				for (int j = 15; j <= i; ++j) {
					if (ans[j] != 0 && myfunc(i, j)) {
						if (i == j)
							res += ans[i] * (ans[j] - 1);
						else
							res += ans[i] * ans[j];
					}
				}
		}
		return res;
	}

	private boolean myfunc(int a, int b) {
		if (b <= 0.5 * a + 7 || b > a || b > 100 && a < 100)
			return false;
		return true;
	}
}
