package leetcode.problem;

public class PredictTheWinner {
    /**
     * 486. 预测赢家
     * https://leetcode-cn.com/problems/predict-the-winner/
     */
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        int first = f(nums, 0, nums.length - 1);
        return first >= (sum - first);
    }

    private int f(int[] nums, int i, int j) {
        if (i == j)
            return nums[i];
        if (i + 1 == j)
            return Math.max(nums[i], nums[j]);
        return Math.max(nums[i] + Math.min(f(nums, i + 1, j - 1), f(nums, i + 2, j)), nums[j] + Math.min(f(nums, i + 1, j - 1), f(nums, i, j - 2)));
    }
}
