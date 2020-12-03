package leetcode.problem;

public class FindTargetSumWays {
	/**
	 * 494. 目标和
	 * https://leetcode-cn.com/problems/target-sum/
	 */
	int ans;

	int[] num;

	public int findTargetSumWays(int[] nums, int S) {
		ans = 0;
		num = nums;
		find(0, S);
		return ans;
	}

	void find(int p, int target) {
		if (p == num.length) {
			if (target == 0) {
				ans++;
			}
		} else {
			find(p + 1, target - num[p]);
			find(p + 1, target + num[p]);
		}
	}
}
