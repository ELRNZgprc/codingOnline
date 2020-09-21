package leetcode.problem;

public class Shuffle {
    /**
     * 1470. 重新排列数组
     * https://leetcode-cn.com/problems/shuffle-the-array/
     */
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                ans[i] = nums[i / 2];
            } else {
                ans[i] = nums[n + i / 2];
            }
        }
        return ans;
    }
}
