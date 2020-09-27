package leetcode.problem;

public class SortColors {
	/**
	 * 75. 颜色分类
	 * https://leetcode-cn.com/problems/sort-colors/
	 */
	public void sortColors(int[] nums) {
		int a = 0;
		int b = 0;
		for (int num : nums) {
			if (num == 0) {
				a++;
			} else if (num == 1) {
				b++;
			}
		}
		for (int i = 0; i < a; i++) {
			nums[i] = 0;
		}
		for (int i = a; i < a + b; i++) {
			nums[i] = 1;
		}
		for (int i = a + b; i < nums.length; i++) {
			nums[i] = 2;
		}
	}
}
